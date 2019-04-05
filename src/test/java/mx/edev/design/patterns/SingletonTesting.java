package mx.edev.design.patterns;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.edev.design.patterns.creational.singleton.BasicSingleton;
import mx.edev.design.patterns.creational.singleton.LazySingleton;
import mx.edev.design.patterns.creational.singleton.ThreadSafeSingleton;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonTesting {

    private static final int THREADS = 10;

    @Test
    public void evaluateBasicSingleton() {
        BasicSingleton instance1 = BasicSingleton.getInstance();
        BasicSingleton instance2 = BasicSingleton.getInstance();

        assertNotNull("Instance shouldn't be null", instance1);
        assertTrue("Singleton failed!!!", instance1 == instance2);
    }

    @Test
    public void evaluateLazySingleton() {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();

        assertNotNull("Instance shouldn't be null", instance1);
        assertTrue("Singleton failed!!!", instance1 == instance2);
    }

    @Test
    public void evaluteThreadSafeSingleton() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
                assertNotNull("Instance shouldn't be null", singleton.getCounter());
                assertTrue("Singleton failed!!!", instance1 == singleton);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
    }

}