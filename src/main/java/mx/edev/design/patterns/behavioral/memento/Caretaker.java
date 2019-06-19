package mx.edev.design.patterns.behavioral.memento;

import java.util.Stack;

/**
 * 
 * Caretaker class
 */
public class Caretaker {
    private Stack<EmployeeMemento> employeeHistory = new Stack<>();

    public void save(Employee employee) {
        employeeHistory.push(employee.save());
    }

    public void restore(Employee emp) {
        emp.restore(employeeHistory.pop());
    }
}