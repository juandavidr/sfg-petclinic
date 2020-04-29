package co.syalar.sfgpetclinic.services;

import co.syalar.sfgpetclinic.model.Owner;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);

    Set<Owner> findAllByLastNameLike(String lastName);
}
