package com.clientmanager.services;

import com.clientmanager.model.Pet;
import com.clientmanager.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLstName(String lastName);
    Vet findById(Long id);
    Vet save(Vet pet);
    Set<Vet> findAll();
}
