package mx.edev.design.patterns.behavioral.chain.of.responsability;

public class Ceo extends Handler {
    @Override
    public void handleRequest(Request request) {
        System.out.println("CEO can approve anything he want");
    }
}