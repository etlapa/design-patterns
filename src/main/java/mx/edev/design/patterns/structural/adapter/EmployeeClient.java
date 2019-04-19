package mx.edev.design.patterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

    public List<Employee> getEmployeeList() {

        List<Employee> employees = new ArrayList<>();

        String id = "1234";
        String firstName = "First name";
        String lastName = "Last name";
        String email = "email@email.com";
        Employee employeeFromDb = new EmployeeDB(id, firstName, lastName, email);

        employees.add(employeeFromDb);

        String cn = "2345";
        String surname = "Surname";
        String givenName = "Given Name";
        String mail = "mail@email.com";
        EmployeeLdap employeeLdap = new EmployeeLdap(cn, surname, givenName, mail);

        employees.add(new EmployeeAdapterLdap(employeeLdap));

        EmployeeCSV employeeCSV = new EmployeeCSV("567,Sherlock,Holmes,sherlock@holmes.com");

        employees.add(new EmployeeAdapterCSV(employeeCSV));

        return employees;
    }
}