package mx.edev.design.patterns.behavioral;

import org.junit.Test;

import mx.edev.design.patterns.behavioral.mediator.Command;
import mx.edev.design.patterns.behavioral.mediator.Light;
import mx.edev.design.patterns.behavioral.mediator.Mediator;
import mx.edev.design.patterns.behavioral.mediator.TurnOffAllLightsCommand;
import mx.edev.design.patterns.behavioral.mediator.TurnOnAllLightsCommand;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MediatorTesting {
    @Test
    public void test() {
        Mediator mediator = new Mediator();

        Light bedroomLight = new Light("Bedroom");
        Light kitchenLight = new Light("Kitchen");

        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        Command turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);
        turnOnAllLightsCommand.execute();

        Command turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);
        turnOffAllLightsCommand.execute();

    }
}