package co.syalar.sfgpetclinic.services;

import co.syalar.sfgpetclinic.model.Vet;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public interface VetService {
    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
