package co.syalar.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jd.rodriguez
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {
    @RequestMapping({ "", "/", "/index", "/index.html" })
    public String listOwners() {
        return "owners/index";
    }
}
