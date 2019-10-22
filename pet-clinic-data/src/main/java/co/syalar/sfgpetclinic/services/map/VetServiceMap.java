package co.syalar.sfgpetclinic.services.map;

import co.syalar.sfgpetclinic.model.Vet;
import co.syalar.sfgpetclinic.services.SpecialtyService;
import co.syalar.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private SpecialtyService specialtyService;

    @Autowired
    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    specialty.setId(specialtyService.save(specialty).getId());
                }
            });
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
