package com.maksiomo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.maksiomo.model.dto.ClientDTO;
import com.maksiomo.model.domain.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "birthDate", dateFormat = "yyyy-MM-dd")
    Client createClientDTOToClient(ClientDTO clientDTO);
}
