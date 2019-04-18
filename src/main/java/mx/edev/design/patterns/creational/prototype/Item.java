package mx.edev.design.patterns.creational.prototype;

import lombok.Data;

@Data
public abstract class Item implements Cloneable {
    private String title;
    private double price;
    private String url;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}