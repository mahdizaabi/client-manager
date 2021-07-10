package com.clientmanager.services.map;

import com.clientmanager.model.Visit;
import com.clientmanager.services.VisitService;

import java.util.Set;

public class VisitServiceMapImplementation extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null || object.getPet().getOwner() == null ||
                object.getPet().getOwner().getId() == null || object.getPet().getId() == null)
            throw new RuntimeException("missing data");
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }
}
