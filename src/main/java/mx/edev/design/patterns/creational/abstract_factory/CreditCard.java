package mx.edev.design.patterns.creational.abstract_factory;

import lombok.Data;

@Data
public abstract class CreditCard {
    protected int cardNumberLength;
    protected int cscNumber;
}