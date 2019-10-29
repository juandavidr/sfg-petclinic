package co.syalar.sfgpetclinic.repositories;

import co.syalar.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd.rodriguez
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
