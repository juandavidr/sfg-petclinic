package co.syalar.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
public class SfgPetClinicApplication  implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SfgPetClinicApplication.class, args);
    }

}
