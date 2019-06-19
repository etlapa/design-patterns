package mx.edev.design.patterns.behavioral.mediator;

import lombok.Getter;

public class Light {
    @Getter
    private boolean isOn = false;
    private String location = "";

    public Light() {
    }

    public Light(String location) {
        this.location = location;
    }

    public void toggle() {
        if (isOn) {
            off();
            isOn = false;
        } else {
            on();
            isOn = true;
        }
    }

    public void on() {
        System.out.println("Light switched on.");
    }

    public void off() {
        System.out.println("Light switched off.");
    }
}