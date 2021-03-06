package com.clientmanager.services;

import com.clientmanager.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
    Object findByName(String name);

    Set<Owner> findAllByLastName(String name);
}
