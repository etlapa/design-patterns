package mx.edev.design.patterns.behavioral;

import org.junit.Test;

import mx.edev.design.patterns.behavioral.observer.MessageStream;
import mx.edev.design.patterns.behavioral.observer.PhoneClient;
import mx.edev.design.patterns.behavioral.observer.Subject;
import mx.edev.design.patterns.behavioral.observer.TabletClient;

public class ObserverTesting {
    @Test
    public void test() {
        Subject subject = new MessageStream();

        PhoneClient phoneClient = new PhoneClient(subject);
        TabletClient tabletClient = new TabletClient(subject);

        phoneClient.addMessage("Here is a new message!");
        tabletClient.addMessage("Another new message!");
    }
}