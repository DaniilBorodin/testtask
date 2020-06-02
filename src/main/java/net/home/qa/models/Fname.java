package net.home.qa.models;

import lombok.Data;

@Data
public class Fname {

    String normal;
    String transcription;

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }
}
