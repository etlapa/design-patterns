package mx.edev.design.patterns.structural.bridge.exercise3;

import java.util.List;

/**
 * Here is the brigde implementation. Composition is in here
 * 
 *
 */
public abstract class Printer {
    public String print(Formatter formatter) {
        return formatter.format(getHeader(), getDetails());
    }

    abstract protected List<Detail> getDetails();

    abstract protected String getHeader();
}