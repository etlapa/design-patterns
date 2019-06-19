package mx.edev.design.patterns.behavioral.memento;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * Originator class
 */
@Data
public class Employee implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1197249311916702543L;

    private String name;
    private String address;
    private String phone;

    public EmployeeMemento save() {
        return new EmployeeMemento(name, phone);
    }

    public void restore(EmployeeMemento restore) {
        this.name = restore.getName();
        this.phone = restore.getPhone();
    }

    @Override
    public String toString() {
        return "name: [" + name + "], address: [" + address + "], phone: [" + phone + "]";
    }
}