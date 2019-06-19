package mx.edev.design.patterns.behavioral.command;

public class OnCommandNoState implements Command {

    private LightNoState light;

    public OnCommandNoState(LightNoState light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

}