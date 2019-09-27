package co.syalar.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jd.rodriguez
 */
@Controller
public class OwnerController {
    @RequestMapping({ "/owners", "/owners/", "/owners/index", "/owners/index.html" })
    public String listOwners() {
        return "owners/index";
    }
}
