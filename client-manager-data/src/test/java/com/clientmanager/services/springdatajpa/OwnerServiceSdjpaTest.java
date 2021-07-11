package com.clientmanager.services.springdatajpa;

import com.clientmanager.model.Owner;
import com.clientmanager.repositories.OwnerRepository;
import com.clientmanager.repositories.PetRepository;
import com.clientmanager.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceSdjpaTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceSdjpa ownerService;

    Owner owner;

    @BeforeEach
    void setUp() {
        this.owner = new Owner();
        this.owner.setId(12L);

    }

    @Test
    void findByLastName() {
        Owner owner = new Owner();
        owner.setLastName("mahouda");
        ownerService.save(owner);
        //we mocked ownerRepository and we have full controll over it
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        assertEquals("mahouda", ownerService.findByLastName("mahouda").getLastName());
        //verify mock has been called inside service
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(new Owner());
        ownerSet.add(new Owner());
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        assertEquals(2, ownerService.findAll().size());
        assertTrue(ownerService.findAll().size() != 0);
    }

    @Test
    void findById() {

        when(ownerRepository.findById(any())).thenReturn(Optional.of(this.owner));
        assertTrue(ownerService.findById(12L).getId() == 12L);
        assertNotNull(ownerService.findById(12L));
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(new Owner());
        assertNotNull(ownerService.save(any(Owner.class)));
    }

    @Test
    void deleteById() {
        ownerService.deleteById(85L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void delete() {
        ownerService.delete(this.owner);
        verify(ownerRepository).delete(any());
    }


}