package mx.edev.design.patterns.behavioral;

import org.junit.Test;

import mx.edev.design.patterns.behavioral.interpreter.AndExpression;
import mx.edev.design.patterns.behavioral.interpreter.Expression;
import mx.edev.design.patterns.behavioral.interpreter.OrExpression;
import mx.edev.design.patterns.behavioral.interpreter.TerminalExpression;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class InterpreterTesting {

    static Expression buildInterpreterTree() {
        Expression terminal1 = new TerminalExpression("Lions");
        return terminal1;
    }

    static Expression buildInterpreterTreeAlternation() {
        Expression terminal1 = new TerminalExpression("Lions");
        Expression terminal2 = new TerminalExpression("Tigers");
        Expression terminal3 = new TerminalExpression("Bears");

        Expression alternation1 = new AndExpression(terminal2, terminal3);
        Expression alternation2 = new OrExpression(terminal1, alternation1);

        return new AndExpression(terminal3, alternation2);
    }

    @Test
    public void simpleTest() {
        String context = "Lions";

        Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));
    }

    @Test
    public void testingAndOr() {
        // String context = "Lions";
        // String context = "Tigers";
        // String context = "Bears";
        String context = "Lions Tigers";
        // String context = "Lions Bears";
        // String context = "Tigers Bears";

        Expression define = buildInterpreterTreeAlternation();

        System.out.println(context + " is " + define.interpret(context));
    }
}