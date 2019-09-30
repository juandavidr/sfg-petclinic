package co.syalar.sfgpetclinic.bootstrap;

import co.syalar.sfgpetclinic.model.Owner;
import co.syalar.sfgpetclinic.model.Vet;
import co.syalar.sfgpetclinic.services.OwnerService;
import co.syalar.sfgpetclinic.services.VetService;
import co.syalar.sfgpetclinic.services.map.OwnerServiceMap;
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

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
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
