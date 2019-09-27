package co.syalar.sfgpetclinic.services;

import co.syalar.sfgpetclinic.model.Pet;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public interface PetService {
    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
