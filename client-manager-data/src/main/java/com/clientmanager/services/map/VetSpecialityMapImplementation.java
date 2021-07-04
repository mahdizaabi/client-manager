package com.clientmanager.services.map;

import com.clientmanager.model.Speciality;
import com.clientmanager.services.VetSpecialityService;

import java.util.Set;

public class VetSpecialityMapImplementation extends AbstractMapService<Speciality, Long> implements VetSpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
