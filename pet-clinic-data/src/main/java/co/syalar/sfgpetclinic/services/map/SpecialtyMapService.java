package co.syalar.sfgpetclinic.services.map;

import co.syalar.sfgpetclinic.model.Specialty;
import co.syalar.sfgpetclinic.services.SpecialtiesService;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
