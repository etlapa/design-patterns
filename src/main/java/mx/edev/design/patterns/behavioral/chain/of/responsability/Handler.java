package mx.edev.design.patterns.behavioral.chain.of.responsability;

import lombok.Setter;

public abstract class Handler {
    @Setter
    protected Handler successor;

    public abstract void handleRequest(Request request);

}