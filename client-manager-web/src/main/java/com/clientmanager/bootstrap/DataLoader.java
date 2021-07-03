package com.clientmanager.bootstrap;

import com.clientmanager.model.Owner;
import com.clientmanager.model.Vet;
import com.clientmanager.services.OwnerService;
import com.clientmanager.services.VetService;
import com.clientmanager.services.map.OwnerServiceMap;
import com.clientmanager.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
        vetService.save(vetx);
        Vet vety = new Vet();
        vety.setFirstName("Lisa");
        vety.setLastName("Naughty");
        vetService.save(vety);
        System.out.println("Vet has been loaded");

    }
}
