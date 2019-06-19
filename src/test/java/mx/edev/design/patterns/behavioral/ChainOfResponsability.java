package mx.edev.design.patterns.behavioral;

import org.junit.Test;

import mx.edev.design.patterns.behavioral.chain.of.responsability.Ceo;
import mx.edev.design.patterns.behavioral.chain.of.responsability.Director;
import mx.edev.design.patterns.behavioral.chain.of.responsability.Request;
import mx.edev.design.patterns.behavioral.chain.of.responsability.RequestType;
import mx.edev.design.patterns.behavioral.chain.of.responsability.Vp;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ChainOfResponsability {

    @Test
    public void test() {
        Director bryan = new Director();
        Vp crystal = new Vp();
        Ceo jeff = new Ceo();

        bryan.setSuccessor(crystal);
        crystal.setSuccessor(jeff);

        Request request = new Request(RequestType.CONFERENCE, 500);
        bryan.handleRequest(request);

        request = new Request(RequestType.PURCHASE, 1000);
        bryan.handleRequest(request); // or crystal works too

        request = new Request(RequestType.PURCHASE, 2000);
        bryan.handleRequest(request);

    }

}