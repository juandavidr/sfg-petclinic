package co.syalar.sfgpetclinic.services;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
