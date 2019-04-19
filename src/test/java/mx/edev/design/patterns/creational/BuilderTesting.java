package mx.edev.design.patterns.creational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.edev.design.patterns.creational.builder.LunchOrder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuilderTesting {

    @Test
    public void evaluateBuilder() {
        LunchOrder.Builder builder = new LunchOrder.Builder();
        assertNotNull("Builder is null!!!", builder);
        builder.meat("Double").bread("White").dressing("Mayo").condiments("Salt");
        LunchOrder lunchOrder = builder.build();
        assertNotNull("build failed!!!", lunchOrder);
        String originalLunch = lunchOrder.toString();
        builder.bread("Wheat");
        String updatedLunch = lunchOrder.toString();
        assertEquals("Builder pattern failed!!!", originalLunch, updatedLunch);
    }

}