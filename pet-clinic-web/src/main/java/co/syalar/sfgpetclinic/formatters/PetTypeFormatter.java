package co.syalar.sfgpetclinic.formatters;

import co.syalar.sfgpetclinic.model.PetType;
import co.syalar.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by jd.rodriguez
 */
@Component
public class PetTypeFormatter implements Formatter<PetType> {
    private final PetTypeService petTypeService;

    @Autowired
    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        return petTypeService.findByName(text);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
