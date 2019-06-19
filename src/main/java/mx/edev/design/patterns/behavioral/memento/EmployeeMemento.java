package mx.edev.design.patterns.behavioral.memento;

import lombok.Getter;

/**
 * 
 * Memento class
 */
@Getter
public class EmployeeMemento {
    private final String name;
    private final String phone;

    public EmployeeMemento(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}