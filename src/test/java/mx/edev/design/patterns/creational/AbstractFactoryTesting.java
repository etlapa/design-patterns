package mx.edev.design.patterns.creational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.edev.design.patterns.creational.abstract_factory.AmexFactory;
import mx.edev.design.patterns.creational.abstract_factory.AmexPlatinumCreditCard;
import mx.edev.design.patterns.creational.abstract_factory.CardType;
import mx.edev.design.patterns.creational.abstract_factory.CreditCard;
import mx.edev.design.patterns.creational.abstract_factory.CreditCardFactory;
import mx.edev.design.patterns.creational.abstract_factory.VisaFactory;
import mx.edev.design.patterns.creational.abstract_factory.VisaGoldCreditCard;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractFactoryTesting {

    @Test
    public void evaluate() {
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);
        assertNotNull("Amex factory failed", abstractFactory);
        assertEquals("This is not an Amex factory!", abstractFactory.getClass(), AmexFactory.class);
        CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);
        assertNotNull("Amex card not created!", card);
        assertEquals("This Amex card is not Platinum", card.getClass(), AmexPlatinumCreditCard.class);
        abstractFactory = CreditCardFactory.getCreditCardFactory(600);
        assertEquals("This is not an Visa factory!", abstractFactory.getClass(), VisaFactory.class);
        assertNotNull("Visa factory failed", abstractFactory);
        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);
        assertNotNull("Visa card not created!", card2);
        assertEquals("This Visa card is not Gold", card2.getClass(), VisaGoldCreditCard.class);
    }
}