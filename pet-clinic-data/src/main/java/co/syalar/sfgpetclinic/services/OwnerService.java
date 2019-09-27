package co.syalar.sfgpetclinic.services;

import co.syalar.sfgpetclinic.model.Owner;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
