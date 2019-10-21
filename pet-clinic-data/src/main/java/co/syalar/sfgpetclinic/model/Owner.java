package co.syalar.sfgpetclinic.model;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public class Owner extends Person {
    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
