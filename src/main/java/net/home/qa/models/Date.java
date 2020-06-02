package net.home.qa.models;

import lombok.Data;

@Data
public class Date {

    String date;
    String digital_time;

    public String getDigital_time() {
        return digital_time;
    }

    public void setDigital_time(String digital_time) {
        this.digital_time = digital_time;
    }
}
