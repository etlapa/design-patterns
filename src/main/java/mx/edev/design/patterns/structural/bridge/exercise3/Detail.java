package mx.edev.design.patterns.structural.bridge.exercise3;

import lombok.Getter;

@Getter
public class Detail {
    private final String label;
    private final String value;

    public Detail(String label, String value) {
        super();
        this.label = label;
        this.value = value;
    }
}