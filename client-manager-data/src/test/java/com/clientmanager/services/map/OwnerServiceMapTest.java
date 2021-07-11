package com.clientmanager.services.map;

import com.clientmanager.model.Owner;
import com.clientmanager.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceMap(new PetTypeServiceMapImplementaion(),
                new PetServiceMap()
        );
        Owner ownerTest = new Owner();
        ownerTest.setFirstName("Jack");
        ownerTest.setId(14L);
        ownerTest.setLastName("Patrick");
        ownerService.save(ownerTest);
        System.out.println("beforeeach is running");
    }

    @Test
    void findAll() {
        Set<Owner> fetchedOwner = ownerService.findAll();
        assertEquals(1, fetchedOwner.size());
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(14L);
        assertEquals("Jack", owner.getFirstName());
    }

    @Test
    void saveWithId() {
      Long id = 18L;
      Owner newOwner = new Owner();
      newOwner.setId(id);
      ownerService.save(newOwner);
      assertNotNull(ownerService.findById(id));
    }
    @Test
    void saveWithoutId() {
        Owner newOwner = new Owner();
        ownerService.save(newOwner);
        assertNotNull(ownerService.save(newOwner).getId());
    }
    @Test
    void saveTwoObjectWithSametId() {
        Owner newOwner = new Owner();
        newOwner.setId(14L);
        ownerService.save(newOwner);
        assertNotNull(ownerService.save(newOwner).getId());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(14L);
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void findByFirstName_ExistentName() {
        assertNotNull(ownerService.findByName("Jack"));
    }
    @Test
    void findByFirstName_NonExistentName() {
        assertNull(ownerService.findByName("NameNotExistent"));
    }

    @Test
    void delete() {
        Owner ownerToDelete = new Owner();
        ownerToDelete.setFirstName("delium");
        ownerService.save(ownerToDelete);
        assertEquals(2, ownerService.findAll().size());
        ownerService.delete(ownerToDelete);
        assertEquals(1, ownerService.findAll().size());
        assertNull(ownerService.findByName("delium"));
    }
}