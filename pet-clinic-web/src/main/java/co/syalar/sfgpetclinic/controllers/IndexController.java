package co.syalar.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jd.rodriguez
 */
@Controller
public class IndexController {
    @RequestMapping({ "", "/", "index", "index.html" })
    public String index() {
        return "index";
    }
}
