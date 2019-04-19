package mx.edev.design.patterns.structural.bridge.exercise2;

public class CircleComposition extends ShapeComposition {

    public CircleComposition(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Circle ");
        color.applyColor();
    }
}