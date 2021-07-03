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
    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner ownerx = new Owner();
        ownerx.setId(1L);
        ownerx.setFirstName("Michel");
        ownerx.setLastName("Weston");
        ownerService.save(ownerx);
        Owner ownery = new Owner();
        ownery.setId(2L);
        ownery.setFirstName("Michel");
        ownery.setLastName("Weston");
        ownerService.save(ownery);
        System.out.println("Loaded owners...");
        Vet vetx = new Vet();
        vetx.setId(1L);
        vetx.setFirstName("Clara");
        vetx.setLastName("Nasty");
        vetService.save(vetx);
        Vet vety = new Vet();
        vety.setId(2L);
        vety.setFirstName("Lisa");
        vety.setLastName("Naughty");
        vetService.save(vety);
        System.out.println("Vet has been loaded");

    }
}
