package mx.edev.design.patterns.behavioral;

import java.util.Iterator;

import org.junit.Test;

import mx.edev.design.patterns.behavioral.iterator.BikeRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class IteratorTesting {
    @Test
    public void test() {
        BikeRepository repo = new BikeRepository();

        repo.addBike("Cervelo");
        repo.addBike("Scott");
        repo.addBike("Fuji");

        Iterator<String> bikeIterator = repo.iterator();

        System.out.println("---------- While loop");
        while (bikeIterator.hasNext()) {
            System.out.println(bikeIterator.next());
        }

        System.out.println("---------- For loop");
        for (String bike : repo) {
            System.out.println(bike);
        }

        System.out.println("---------- ForEach loop");
        repo.forEach(bike -> System.out.println(bike));

    }
}