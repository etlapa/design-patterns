package mx.edev.design.patterns.structural.adapter;

import lombok.Data;

@Data
public class EmployeeLdap {

    private String cn;
    private String surname;
    private String givenName;
    private String mail;

    public EmployeeLdap(String cn, String surname, String givenName, String mail) {
        super();
        this.cn = cn;
        this.surname = surname;
        this.givenName = givenName;
        this.mail = mail;
    }

}