package net.home.qa.models;

import lombok.Data;

@Data
public class Address {

    String country;
    String postcode;
    String city;
    String street;
    Integer home;
    Integer apartment;

}
