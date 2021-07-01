package com.clientmanager.services;

import com.clientmanager.model.Owner;
import com.clientmanager.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findByLstName(String lastName);
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
