package co.syalar.sfgpetclinic.services;

import co.syalar.sfgpetclinic.model.Owner;

/**
 * Created by jd.rodriguez
 */
public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
