package mx.edev.design.patterns.creational.abstract_factory;

public abstract class CreditCardFactory {
    // public CreditCard getCreditCard(CardType cardType) {
    // return null;
    // }
    //
    // public Validator getValidator(CardType cardType) {
    // return null;
    // }
    public static CreditCardFactory getCreditCardFactory(int creditScore) {
        if (creditScore > 650) {
            return new AmexFactory();
        } else {
            return new VisaFactory();
        }
    }

    public abstract CreditCard getCreditCard(CardType cardType);

    public abstract Validator getValidator(CardType cardType);
}