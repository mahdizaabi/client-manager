package com.clientmanager.services.springdatajpa;

import com.clientmanager.model.Visit;
import com.clientmanager.repositories.VisitRepository;
import com.clientmanager.services.VisitService;

import java.util.Set;

public class VisitServiceSdjpa implements VisitService {
    private final VisitRepository visitRepository;

    public VisitServiceSdjpa(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return null;
    }

    @Override
    public Visit findById(Long aLong) {
        return null;
    }

    @Override
    public Visit save(Visit object) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Visit object) {

    }
}
