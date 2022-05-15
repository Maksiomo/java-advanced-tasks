package com.maksiomo.mapper;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;
import com.maksiomo.mapper.converters.StringToLocalDateConverter;
import com.maksiomo.model.dto.ClientDTO;
import com.maksiomo.model.domain.Client;

@Component
@Slf4j
public class ClientMapper extends OrikaMapper {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(ClientDTO.class, Client.class)
                .customize(new CustomMapper<ClientDTO, Client>() {
                    @Override
                    public void mapAtoB(ClientDTO source, Client target, MappingContext context) {
                        String[] values = source.getFullName().split(" ");
                        target.setLastName(values[0]);
                        target.setFirstName(values[1]);
                        target.setMiddleName(values[2]);
                    }
                })
                .fieldMap("birthDate", "clientBirthDate")
                .converter(StringToLocalDateConverter.CONVERTER_CODE)
                .add()
                .byDefault()
                .register();
    }

    public Client map(ClientDTO from) {
        return mapperFactory.getMapperFacade(ClientDTO.class, Client.class)
                .map(from);
    }

}
