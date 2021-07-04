package com.clientmanager.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{
    private String name;
    private PetType petType;
    private Owner owner;
    private LocalDate birthdate;

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public PetType getPetType() {
        return petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
