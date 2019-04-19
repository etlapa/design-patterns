package mx.edev.design.patterns.structural;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.edev.design.patterns.structural.bridge.exercise1.BlueCircle;
import mx.edev.design.patterns.structural.bridge.exercise1.Circle;
import mx.edev.design.patterns.structural.bridge.exercise1.Red;
import mx.edev.design.patterns.structural.bridge.exercise1.RedSquare;
import mx.edev.design.patterns.structural.bridge.exercise1.Square;
import mx.edev.design.patterns.structural.bridge.exercise2.Blue;
import mx.edev.design.patterns.structural.bridge.exercise2.CircleComposition;
import mx.edev.design.patterns.structural.bridge.exercise2.Color;
import mx.edev.design.patterns.structural.bridge.exercise2.ShapeComposition;
import mx.edev.design.patterns.structural.bridge.exercise2.SquareComposition;
import mx.edev.design.patterns.structural.bridge.exercise3.Formatter;
import mx.edev.design.patterns.structural.bridge.exercise3.HtmlFormatter;
import mx.edev.design.patterns.structural.bridge.exercise3.Movie;
import mx.edev.design.patterns.structural.bridge.exercise3.MoviePrinter;
import mx.edev.design.patterns.structural.bridge.exercise3.PrintFormatter;
import mx.edev.design.patterns.structural.bridge.exercise3.Printer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BridgeTesting {

    /**
     * For this exercise work fine. If a new type of shape is required, a new
     * class should be created. e.g.: GreenCircle
     */
    @Test
    public void evaluate() {
        Circle circle = new BlueCircle();

        Square square = new RedSquare();

        assertNotNull("Circle object is not created!", circle);

        circle.applyColor();

        assertNotNull("Square object is not created!", circle);

        square.applyColor();
    }

    @Test
    public void evaluateComposition() {

        Color blue = new Blue();

        ShapeComposition square = new SquareComposition(blue);

        assertNotNull("Square object is not created!", square);

        square.applyColor();

        Color red = new Red();

        ShapeComposition circle = new CircleComposition(red);

        assertNotNull("Circle object is not created!", circle);

        circle.applyColor();
    }

    @Test
    public void evaluateMovieExample() {
        Movie movie = new Movie();

        movie.setClassification("Action");
        movie.setTitle("John Wick");
        movie.setRuntime("14:15");
        movie.setYear("2014");

        assertNotNull("Movie not created!", movie);

        // Printer knows nothing about the implementation of MoviePrinter
        Printer moviePrinter = new MoviePrinter(movie);
        assertNotNull("Movie printer not created!", moviePrinter);

        // Formatter knows nothing about the implementation of PrintFormatter
        Formatter printFormatter = new PrintFormatter();
        assertNotNull("Formatter not created!", printFormatter);

        String printedMaterial = moviePrinter.print(printFormatter);

        assertNotNull("Printed material not created!", printedMaterial);

        System.out.println(printedMaterial);

        // Formatter knows nothing about the implementation of HtmlFormatter
        Formatter htmlFormatter = new HtmlFormatter();

        assertNotNull("Html formatter not created!", htmlFormatter);

        String printedHtmlMaterial = moviePrinter.print(htmlFormatter);

        assertNotNull("Html output not created!", printedHtmlMaterial);

        System.out.println(printedHtmlMaterial);

    }
}