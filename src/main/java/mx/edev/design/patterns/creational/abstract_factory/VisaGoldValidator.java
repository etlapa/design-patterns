package mx.edev.design.patterns.creational.abstract_factory;

public class VisaGoldValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}