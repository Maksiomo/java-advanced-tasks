package ru.nshi.demo.mapper;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;
import ru.nshi.demo.mapper.converter.StringToLocalDateConverter;
import ru.nshi.demo.model.domain.Person;
import ru.nshi.demo.model.dto.CreatePersonDto;

/**
 * @author rassafel
 */
@Component
@Slf4j
public class PersonMapper extends OrikaMapper {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(CreatePersonDto.class, Person.class)
            .field("rawAge", "age")
            .customize(new CustomMapper<CreatePersonDto, Person>() {
                @Override
                public void mapAtoB(CreatePersonDto source, Person target, MappingContext context) {
                    String[] values = source.getFio().split("\\s+");
                    target.setLastName(values[0]);
                    target.setFirstName(values[1]);
                    target.setMiddleName(values[2]);
                }
            })
            .fieldMap("birthDate", "personBirthDate")
            .converter(StringToLocalDateConverter.CONVERTER_CODE)
            .add()
            .byDefault()
            .register();
    }

    public Person map(CreatePersonDto from) {
        return mapperFactory.getMapperFacade(CreatePersonDto.class, Person.class)
            .map(from);
    }
}
