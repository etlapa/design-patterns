package mx.edev.design.patterns.structural.bridge.exercise1;

import mx.edev.design.patterns.structural.bridge.exercise2.Color;

public class Red implements Color {

    @Override
    public void applyColor() {
        System.out.println("Print red");
    }

}