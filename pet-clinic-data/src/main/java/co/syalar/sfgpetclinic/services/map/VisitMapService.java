package co.syalar.sfgpetclinic.services.map;

import co.syalar.sfgpetclinic.model.Visit;
import co.syalar.sfgpetclinic.services.PetService;
import co.syalar.sfgpetclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
@Service
@Profile({ "default", "map" })
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    private PetService petService;

    @Autowired
    public VisitMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
