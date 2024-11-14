package com.example.barbosa.domain.Barber;

public class Barber {
    private String name;
    private String specialities;

    public Barber(String specialities, String name) {
        this.specialities = specialities;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSpecialities() {
        return specialities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }
}
