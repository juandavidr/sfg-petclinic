package co.syalar.sfgpetclinic.model;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public class Vet extends Person {
    private Set<Specialty> specialties;

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
