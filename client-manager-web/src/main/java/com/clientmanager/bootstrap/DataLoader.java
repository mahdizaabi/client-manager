package com.clientmanager.bootstrap;

import com.clientmanager.model.*;
import com.clientmanager.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final VetSpecialityService vetSpecialityService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      PetService petService,
                      VetSpecialityService vetSpecialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.vetSpecialityService = vetSpecialityService;
    }
    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0 ){
            loadData();
        }
    }
    private void loadData() {
        Owner ownerx = new Owner();
        ownerx.setFirstName("Patrice");
        ownerx.setLastName("lumiére");
        ownerService.save(ownerx);
        Owner ownery = new Owner();
        ownery.setFirstName("Jean luc");
        ownery.setLastName("catobre");
        ownerService.save(ownery);
        System.out.println("Loaded owners...");
        Vet vetx = new Vet();
        vetx.setFirstName("Clara");
        vetx.setLastName("Nasty");
        Vet vety = new Vet();
        vety.setFirstName("Lisa");
        vety.setLastName("Naughty");
        System.out.println("Vet has been loaded");
        PetType pettypex = new PetType();
        pettypex.setName("bird");
        this.petTypeService.save(pettypex);

        System.out.println("petype loaded");
        PetType pettypey = new PetType();
        pettypex.setName("Dog");
        Pet petx = new Pet();
        petx.setName("Rexr");
        petx.setPetType(pettypex);
        ownerx.getPets().add(petx);
        ownerService.save(ownerx);
        System.out.println("final");
        System.out.println("from run bean:");
        System.out.println((long) ownerx.getPets().size());
        System.out.println(petService.findAll().size());
        System.out.println(petService.findById(1L).getName());

        Speciality radiology = new Speciality();
        radiology.setDescription("radiolgies and sacanning");

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery and dentiste");
        Speciality savedSpecRadiology = vetSpecialityService.save(radiology);
        Speciality savedSpecSurgery = vetSpecialityService.save(surgery);
        vetx.getSpecialities().add(savedSpecSurgery);
        vety.getSpecialities().add(savedSpecRadiology);

        vetService.save(vetx);
        vetService.save(vety);


    }
}
