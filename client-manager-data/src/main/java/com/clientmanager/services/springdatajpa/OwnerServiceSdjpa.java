package com.clientmanager.services.springdatajpa;

import com.clientmanager.model.Owner;
import com.clientmanager.repositories.OwnerRepository;
import com.clientmanager.repositories.PetRepository;
import com.clientmanager.repositories.PetTypeRepository;
import com.clientmanager.services.OwnerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class OwnerServiceSdjpa implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerServiceSdjpa(OwnerRepository ownerRepository,
                             PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> ownerList = new HashSet<>();
        ownerRepository.findAll().forEach(ownerList::add);
        return ownerList;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> owner = ownerRepository.findById(aLong);
        return owner.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    public Owner findByName(String name){
        return new Owner();
    }

    @Override
    public Set<Owner> findAllByLastName(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

}
