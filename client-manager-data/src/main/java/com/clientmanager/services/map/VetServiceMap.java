package com.clientmanager.services.map;

import com.clientmanager.model.Speciality;
import com.clientmanager.model.Vet;
import com.clientmanager.services.VetService;
import com.clientmanager.services.VetSpecialityService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final VetSpecialityService vetSpecialityService;

    public VetServiceMap(VetSpecialityService vetSpecialityService) {
        this.vetSpecialityService = vetSpecialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() != 0) {
            object.getSpecialities().forEach(speciality -> {
                /* check if speciality not persisted on the Speciality table */
                if (speciality.getId() == null) {
                    Speciality persistedSpeciality = vetSpecialityService.save(speciality);
                    speciality.setId(persistedSpeciality.getId());
                }else {
                    System.out.println("Specialitie already persisted! --from VetServiceMap");
                }
            });
        } else {
            System.out.println("speciality can't be empty!");
        }
        return super.save(object);
    }


    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
