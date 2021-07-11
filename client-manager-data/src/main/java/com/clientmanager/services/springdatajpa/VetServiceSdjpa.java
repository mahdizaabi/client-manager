package com.clientmanager.services.springdatajpa;

import com.clientmanager.model.Owner;
import com.clientmanager.model.Vet;
import com.clientmanager.repositories.VetRepository;
import com.clientmanager.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetServiceSdjpa implements VetService {
    private final VetRepository vetRepository;

    public VetServiceSdjpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vetList = new HashSet<>();
        vetRepository.findAll().forEach(vetList::add);
        return vetList;
    }

    @Override
    public Vet findById(Long aLong) {
        Optional<Vet> vet = vetRepository.findById(aLong);
        return vet.orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }


}
