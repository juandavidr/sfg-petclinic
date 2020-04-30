package co.syalar.sfgpetclinic.converters;

import co.syalar.sfgpetclinic.model.PetType;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by jd.rodriguez
 */
public class StringToPetTypeConverter implements Converter<String, PetType> {


    @Override
    public PetType convert(String source) {
        return PetType.builder().name(source).build();
    }
}
