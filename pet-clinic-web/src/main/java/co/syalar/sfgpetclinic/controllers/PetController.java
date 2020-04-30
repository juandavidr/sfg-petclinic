package co.syalar.sfgpetclinic.controllers;

import co.syalar.sfgpetclinic.model.Owner;
import co.syalar.sfgpetclinic.model.Pet;
import co.syalar.sfgpetclinic.model.PetType;
import co.syalar.sfgpetclinic.services.OwnerService;
import co.syalar.sfgpetclinic.services.PetService;
import co.syalar.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by jd.rodriguez
 */
@RequestMapping("/owners/{ownerId}")
@Controller
public class PetController {
    private static final String VIEWS_PET_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private PetTypeService petTypeService;
    private PetService petService;
    private OwnerService ownerService;

    @Autowired
    public PetController(PetTypeService petTypeService, PetService petService,
            OwnerService ownerService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetType() {
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return this.ownerService.findById(ownerId);
    }

    @GetMapping("pets/new")
    public ModelAndView newPet(Owner owner) {
        ModelAndView mav = new ModelAndView(VIEWS_PET_CREATE_OR_UPDATE_FORM);
        Pet pet = Pet.builder().build();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        mav.addObject("pet", pet);
        return mav;
    }

    @PostMapping("pets/new")
    public String createPet(Owner owner, @Valid Pet pet, BindingResult result) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already existsl");
        }
        if (result.hasErrors()) {
            return VIEWS_PET_CREATE_OR_UPDATE_FORM;
        } else {
            pet.setPetType(petTypeService.findByName(pet.getPetType().getName()));
            owner.getPets().add(pet);
            pet.setOwner(owner);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId().toString();
        }
    }

    @GetMapping("pets/{petId}/edit")
    public String editPet(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PET_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("pets/{petId}/edit")
    public String editPet(@Valid Pet pet,@PathVariable Long petId, Owner owner, BindingResult result, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PET_CREATE_OR_UPDATE_FORM;
        } else {
            pet.setId(petId);
            pet.setPetType(petTypeService.findByName(pet.getPetType().getName()));
            pet.setOwner(owner);
            petService.save(pet);
            owner.getPets().add(pet);
            return "redirect:/owners/" + owner.getId().toString();
        }
    }

}
