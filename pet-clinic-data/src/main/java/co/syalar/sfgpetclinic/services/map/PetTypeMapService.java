package co.syalar.sfgpetclinic.services.map;

import co.syalar.sfgpetclinic.model.PetType;
import co.syalar.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
@Service
@Profile({ "default", "map" })
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override public PetType findByName(String name) {
        return map.values()
                .stream()
                .filter(petType -> name.equals(petType.getName()))
                .findAny()
                .orElse(null);
    }
}
