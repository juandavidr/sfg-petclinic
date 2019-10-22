package co.syalar.sfgpetclinic.services.map;

import co.syalar.sfgpetclinic.model.Owner;
import co.syalar.sfgpetclinic.model.Pet;
import co.syalar.sfgpetclinic.services.OwnerService;
import co.syalar.sfgpetclinic.services.PetService;
import co.syalar.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {

            object.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                } else {
                    throw new RuntimeException("Pet Type is required");
                }
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });

            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override public Owner findByLastName(String lastName) {
        return null;
    }
}
