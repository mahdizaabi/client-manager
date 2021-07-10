package com.clientmanager.repositories;

import com.clientmanager.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    //no need to implement any methods, spring JPA provide us an implementation
    //for tthis repositry on runtime

    //you may add some method Query here findByIdAndName (for example)
    Owner findByLastName(String lastName);
}
