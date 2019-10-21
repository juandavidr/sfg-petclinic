package co.syalar.sfgpetclinic.model;

/**
 * Created by jd.rodriguez
 */
public class Specialty extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
