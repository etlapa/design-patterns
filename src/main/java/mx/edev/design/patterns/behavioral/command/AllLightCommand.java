package mx.edev.design.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class AllLightCommand implements Command {

    private List<Light> lights = new ArrayList<>();

    public AllLightCommand(List<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.forEach(light -> light.toggle());
    }

}
