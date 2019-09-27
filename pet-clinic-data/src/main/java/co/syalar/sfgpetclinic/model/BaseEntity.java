package co.syalar.sfgpetclinic.model;

import java.io.Serializable;

/**
 * Created by jd.rodriguez
 */
public class BaseEntity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
