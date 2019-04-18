package mx.edev.design.patterns.creational.abstract_factory;

public class VisaBlackValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}