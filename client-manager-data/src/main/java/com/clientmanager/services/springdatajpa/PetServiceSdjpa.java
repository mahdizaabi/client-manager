package com.clientmanager.services.springdatajpa;

import com.clientmanager.model.Owner;
import com.clientmanager.model.Pet;
import com.clientmanager.model.PetType;
import com.clientmanager.repositories.PetRepository;
import com.clientmanager.repositories.PetTypeRepository;
import com.clientmanager.services.PetService;
import com.clientmanager.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class PetServiceSdjpa implements PetService {
    private final PetRepository petRepository;

    public PetServiceSdjpa(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public Set<Pet> findAll() {
        Set<Pet> petList = new HashSet<>();
        petRepository.findAll().forEach(petList::add);
        return petList;    }

    @Override
    public Pet findById(Long aLong) {
        Optional<Pet> owner = petRepository.findById(aLong);
        return owner.orElse(null);    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }
}
