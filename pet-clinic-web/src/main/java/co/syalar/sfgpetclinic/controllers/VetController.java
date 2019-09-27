package co.syalar.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jd.rodriguez
 */
@RequestMapping("/vets")
@Controller
public class VetController {
    @RequestMapping({ "", "/", "/index", "/index.html" })
    public String listVets() {
        return "vets/index";
    }
}
