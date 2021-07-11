package com.clientmanager.services.springdatajpa;

import com.clientmanager.model.Owner;
import com.clientmanager.model.Pet;
import com.clientmanager.model.PetType;
import com.clientmanager.repositories.PetTypeRepository;
import com.clientmanager.services.PetService;
import com.clientmanager.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeServiceSdjpa implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceSdjpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<PetType> findAll() {

        Set<PetType> petType = new HashSet<>();
        petTypeRepository.findAll().forEach(petType::add);
        return petType;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }
}
