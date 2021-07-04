package com.clientmanager.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{

    /*  initialize the hashset to avoid null pointer*/
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
