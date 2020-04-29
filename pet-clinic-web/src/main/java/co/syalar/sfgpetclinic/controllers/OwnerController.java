package co.syalar.sfgpetclinic.controllers;

import co.syalar.sfgpetclinic.model.Owner;
import co.syalar.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

/**
 * Created by jd.rodriguez
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {
    private static final String VIEWS_ORDER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }
        Set<Owner> results = this.ownerService.findAllByLastNameLike(owner.getLastName());
        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "notfound");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject("owner", ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView newOwner() {
        ModelAndView mav = new ModelAndView(VIEWS_ORDER_CREATE_OR_UPDATE_FORM);
        mav.addObject("owner", Owner.builder().build());
        return mav;
    }

    @GetMapping("/{ownerId}/edit")
    public ModelAndView editOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView(VIEWS_ORDER_CREATE_OR_UPDATE_FORM);
        mav.addObject("owner", ownerService.findById(ownerId));
        return mav;
    }

    @PostMapping("/{ownerId}/edit")
    public String editOwner(@PathVariable Long ownerId, Owner owner, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return VIEWS_ORDER_CREATE_OR_UPDATE_FORM;
        } else {
            if (owner.getId() == null || owner.getId() == 0l) {
                owner.setId(ownerId);
            }
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId().toString();
        }
    }

    @PostMapping("/new")
    public String createOwner(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_ORDER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId().toString();
        }
    }

}
