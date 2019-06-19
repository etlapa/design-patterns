package mx.edev.design.patterns.behavioral;

import org.junit.Test;

import mx.edev.design.patterns.behavioral.memento.Caretaker;
import mx.edev.design.patterns.behavioral.memento.Employee;

public class MementoTesting {
    @Test
    public void test() {

        Caretaker caretaker = new Caretaker();

        Employee emp = new Employee();
        emp.setName("John Wick");
        emp.setAddress("111 Main Street");
        emp.setPhone("111 222 3333");

        System.out.println("Before saved: " + emp);

        caretaker.save(emp);

        emp.setPhone("222 3333 4444");

        caretaker.save(emp);

        System.out.println("Saved: " + emp);

        // Not saved yet!
        emp.setPhone("333 444 5555");

        System.out.println("Updated but not saved: " + emp);

        caretaker.restore(emp);

        System.out.println("Undo: " + emp);

        caretaker.restore(emp);

        System.out.println("Undo (original values): " + emp);

    }
}