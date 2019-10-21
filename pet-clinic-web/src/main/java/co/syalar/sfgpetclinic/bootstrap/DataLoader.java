package co.syalar.sfgpetclinic.bootstrap;

import co.syalar.sfgpetclinic.model.Owner;
import co.syalar.sfgpetclinic.model.PetType;
import co.syalar.sfgpetclinic.model.Vet;
import co.syalar.sfgpetclinic.services.OwnerService;
import co.syalar.sfgpetclinic.services.PetTypeService;
import co.syalar.sfgpetclinic.services.VetService;
import co.syalar.sfgpetclinic.services.map.OwnerServiceMap;
import co.syalar.sfgpetclinic.services.map.PetTypeServiceMap;
import co.syalar.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jd.rodriguez
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
        petTypeService = new PetTypeServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded pettypes..." + petTypeService.findAll().size());

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleganne");
        ownerService.save(owner2);
        System.out.println("Loaded owners..." + ownerService.findAll().size());

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);
        System.out.println("Loaded vets..." + vetService.findAll().size());
    }
}
