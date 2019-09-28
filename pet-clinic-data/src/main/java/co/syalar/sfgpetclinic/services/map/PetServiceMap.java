package co.syalar.sfgpetclinic.services.map;

import co.syalar.sfgpetclinic.model.Pet;
import co.syalar.sfgpetclinic.services.PetService;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
