package com.clientmanager.repositories;

import com.clientmanager.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long > {
}
