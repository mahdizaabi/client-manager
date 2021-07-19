package com.clientmanager.services.map;

import com.clientmanager.model.Owner;
import com.clientmanager.model.Pet;
import com.clientmanager.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Service
//active when profile is default: no profile is set, or when profile is "map"
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    final PetTypeServiceMapImplementaion petTypeService;
    final PetServiceMap petServiceMap;

    public OwnerServiceMap(PetTypeServiceMapImplementaion petTypeService, PetServiceMap petServiceMap) {
        this.petTypeService = petTypeService;
        this.petServiceMap = petServiceMap;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        /* save new pet-Type if it's not already exist on the PetTypes table*/
                        /* Owner can have pet, with type inserted on the fly without id, ut hus type entity dosent have an id on the pettype table
                         * */
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException(("pet type is required"));
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petServiceMap.save(pet);
                        System.out.println(savedPet.getId());
                        pet.setId(savedPet.getId());
                        System.out.println(petServiceMap.findAll().size());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }
    public Owner findByName(String name) {
     return this.findAll()
             .stream()
             .filter(owner -> owner.getFirstName().equalsIgnoreCase(name))
             .findFirst()
             .orElse(null);
    }

    @Override
    public Set<Owner> findAllByLastName(String name) {
        return null;
    }
}
