package mx.edev.design.patterns.structural;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.edev.design.patterns.structural.adapter.Employee;
import mx.edev.design.patterns.structural.adapter.EmployeeAdapterCSV;
import mx.edev.design.patterns.structural.adapter.EmployeeAdapterLdap;
import mx.edev.design.patterns.structural.adapter.EmployeeCSV;
import mx.edev.design.patterns.structural.adapter.EmployeeClient;
import mx.edev.design.patterns.structural.adapter.EmployeeDB;
import mx.edev.design.patterns.structural.adapter.EmployeeLdap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdapterTesting {

    @Test
    public void evaluateFinalMethod() {
        EmployeeClient client = new EmployeeClient();

        assertNotNull("Client is null", client);

        List<Employee> employees = client.getEmployeeList();

        assertNotNull("Employee list is not created!", employees);

        assertTrue("Employee list is empty", employees.size() > 0);

        assertTrue("Empty size is different than 3", employees.size() == 3);

        // System.out.println(employees);
    }

    @Test
    public void evaluateAdapter() {
        String id = "1234";
        String firstName = "First name";
        String lastName = "Last name";
        String email = "email@email.com";
        Employee employee1 = new EmployeeDB(id, firstName, lastName, email);

        assertNotNull("Employee is null!!!", employee1);
        assertTrue("employee1 is not instance of Employee", employee1 instanceof Employee);

        String cn = "2345";
        String surname = "Surname";
        String givenName = "Given Name";
        String mail = "mail@email.com";
        EmployeeLdap employeeLdap = new EmployeeLdap(cn, surname, givenName, mail);
        assertNotNull("EmployeeLdap is null!!!", employeeLdap);
        Employee employee2 = new EmployeeAdapterLdap(employeeLdap);
        assertTrue("employee2 is not instance of Employee", employee2 instanceof Employee);

        EmployeeCSV employeeCSV = new EmployeeCSV("567,Sherlock,Holmes,sherlock@holmes.com");
        assertNotNull("EmployeeLdap is null!!!", employeeCSV);
        Employee employee3 = new EmployeeAdapterCSV(employeeCSV);
        assertTrue("employee3 is not instance of Employee", employee3 instanceof Employee);
    }
}