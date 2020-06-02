package net.home.qa.models;

import lombok.Data;

@Data
public class Person {

    Name name;
    Gender gender;
    Date date;
    Address address;
    String phone;
    String color;
    String login;
    String password;
    String userpic;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
