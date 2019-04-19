package mx.edev.design.patterns.structural.adapter;

import java.util.StringTokenizer;

import lombok.Data;

@Data
public class EmployeeCSV {
    private int id;
    private String firstname;
    private String lastname;
    private String emailAddress;

    private Employee instance;

    public EmployeeCSV(String values) {
        StringTokenizer tokenizer = new StringTokenizer(values, ",");
        if (tokenizer.hasMoreTokens()) {
            id = Integer.parseInt(tokenizer.nextToken());
        }
        if (tokenizer.hasMoreElements()) {
            firstname = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreElements()) {
            lastname = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreElements()) {
            emailAddress = tokenizer.nextToken();
        }
    }
}