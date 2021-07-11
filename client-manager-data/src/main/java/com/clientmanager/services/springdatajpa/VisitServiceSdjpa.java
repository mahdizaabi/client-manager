package com.clientmanager.services.springdatajpa;

import com.clientmanager.model.Visit;
import com.clientmanager.repositories.VisitRepository;
import com.clientmanager.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class VisitServiceSdjpa implements VisitService {
    private final VisitRepository visitRepository;

    public VisitServiceSdjpa(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visitList = new HashSet<>();
        visitRepository.findAll().forEach(visitList::add);
        return visitList;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }
}
