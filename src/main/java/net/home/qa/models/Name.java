package net.home.qa.models;

import lombok.Data;

@Data
public class Name {
    Fname fname;
    Lname lname;
    Patronymic patronymic;

    public Fname getFname() {
        return fname;
    }

    public void setFname(Fname fname) {
        this.fname = fname;
    }

}
