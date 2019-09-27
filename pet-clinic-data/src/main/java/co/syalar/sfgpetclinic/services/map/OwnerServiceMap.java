package co.syalar.sfgpetclinic.services.map;

import co.syalar.sfgpetclinic.model.Owner;
import co.syalar.sfgpetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
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
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
