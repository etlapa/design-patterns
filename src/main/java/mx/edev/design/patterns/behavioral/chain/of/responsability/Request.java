package mx.edev.design.patterns.behavioral.chain.of.responsability;

import lombok.Getter;

@Getter
public class Request {
    private RequestType requestType;
    private double amount;

    public Request(RequestType request, double amount) {
        this.requestType = request;
        this.amount = amount;
    }
}