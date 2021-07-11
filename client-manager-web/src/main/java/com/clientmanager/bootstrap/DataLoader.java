package com.clientmanager.bootstrap;

import com.clientmanager.model.*;
import com.clientmanager.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final VetSpecialityService vetSpecialityService;
    private final VisitService visitService;
    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      PetService petService,
                      VetSpecialityService vetSpecialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.vetSpecialityService = vetSpecialityService;
        this.visitService = visitService;
    }
    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0 ){
            loadData();
        }
    }
    private void loadData() {

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

        PetType pettypex = new PetType();
        pettypex.setName("bird");
        this.petTypeService.save(pettypex);

        System.out.println("petype loaded");
        PetType pettypey = new PetType();
        pettypex.setName("Dog");
        // create Pet and save it to the pet table
        Pet petx = new Pet();
        petx.setName("petx");
        PetType typex = new PetType();
        typex.setName("typex");
        petx.setPetType(typex);
        //petService.save(petx);
        /*** Create owner ***/
        Owner ownerx = new Owner();
        ownerx.setFirstName("Patrice");
        ownerx.setLastName("lumiére");
        //ownerService.save(ownerx);
        Set<Pet> x = ownerx.getPets();
        x.add(petx);
        ownerx.setPets(x);
        petx.setOwner(ownerx);
        ownerService.save(ownerx);

        Visit visitx = new Visit();
        visitx.setDate(LocalDate.now());
        visitx.setPet(petx);
        petx.getVisits().add(visitx);
        visitx.setDescription("x visit at monday was good.");
        visitService.save(visitx);
        petx.setName("Rexr");
        petx.setPetType(pettypex);
        ownerx.getPets().add(petx);
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
        System.out.println("Test_Test_Test_Test");
        System.out.println(petService.findById(1L).getOwner().getFirstName());


    }
}
