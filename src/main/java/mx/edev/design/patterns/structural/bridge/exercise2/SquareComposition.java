package mx.edev.design.patterns.structural.bridge.exercise2;

public class SquareComposition extends ShapeComposition {

    public SquareComposition(Color color) {
        super(color);
    }

    /**
     * This method is using the composition
     */
    @Override
    public void applyColor() {
        System.out.print("Square ");
        color.applyColor();
    }

}