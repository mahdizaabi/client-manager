package com.clientmanager.services.map;

import com.clientmanager.model.PetType;
import com.clientmanager.services.PetTypeService;

import java.util.Set;

public class PetTypeServiceMapImplementaion extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public PetType save(PetType petTypeService) {
        return super.save(petTypeService);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

}
