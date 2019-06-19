package mx.edev.design.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import mx.edev.design.patterns.behavioral.command.AllLightCommand;
import mx.edev.design.patterns.behavioral.command.Command;
import mx.edev.design.patterns.behavioral.command.Light;
import mx.edev.design.patterns.behavioral.command.LightNoState;
import mx.edev.design.patterns.behavioral.command.OnCommandNoState;
import mx.edev.design.patterns.behavioral.command.Switch;
import mx.edev.design.patterns.behavioral.command.ToggleCommand;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CommandTesting {
    /**
     * This command is not holding the state
     */
    // @Test
    public void simpleCommand() {
        LightNoState light = new LightNoState();
        Switch lightSwitch = new Switch();

        Command onCommand = new OnCommandNoState(light);

        lightSwitch.storeAndExecute(onCommand);
    }

    // @Test
    public void command() {
        Light light = new Light();
        Switch lightSwitch = new Switch();

        Command onCommand = new ToggleCommand(light);

        lightSwitch.storeAndExecute(onCommand);
        lightSwitch.storeAndExecute(onCommand);
        lightSwitch.storeAndExecute(onCommand);
    }

    @Test
    public void macroCommand() {
        Light bedroomLight = new Light();
        Light kitchenLight = new Light();
        Switch lightSwitch = new Switch();

        Command onCommand = new ToggleCommand(bedroomLight);
        lightSwitch.storeAndExecute(onCommand);
        // lightSwitch.storeAndExecute(onCommand);
        // lightSwitch.storeAndExecute(onCommand);

        List<Light> lights = new ArrayList<>();
        lights.add(bedroomLight);
        lights.add(kitchenLight);

        Command allLightsCommand = new AllLightCommand(lights);
        lightSwitch.storeAndExecute(allLightsCommand);

    }
}