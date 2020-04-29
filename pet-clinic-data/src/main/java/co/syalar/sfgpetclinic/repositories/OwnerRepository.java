package co.syalar.sfgpetclinic.repositories;

import co.syalar.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
    Set<Owner> findByLastNameContainsIgnoreCase(String lastName);
}
