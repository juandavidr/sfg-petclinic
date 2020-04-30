package co.syalar.sfgpetclinic.services;

import co.syalar.sfgpetclinic.model.PetType;

/**
 * Created by jd.rodriguez
 */
public interface PetTypeService extends CrudService<PetType, Long> {
    PetType findByName(String name);
}
