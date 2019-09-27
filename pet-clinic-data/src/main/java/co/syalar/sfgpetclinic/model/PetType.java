package co.syalar.sfgpetclinic.model;

/**
 * Created by jd.rodriguez
 */
public class PetType extends BaseEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
