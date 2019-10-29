package co.syalar.sfgpetclinic.repositories;

import co.syalar.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd.rodriguez
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
