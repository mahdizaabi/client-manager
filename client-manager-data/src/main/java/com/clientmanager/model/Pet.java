package com.clientmanager.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pet extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Column(name = "birth_date")
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
