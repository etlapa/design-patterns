package mx.edev.design.patterns.structural.bridge.exercise2;

public abstract class ShapeComposition {
    protected Color color;

    public ShapeComposition(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}