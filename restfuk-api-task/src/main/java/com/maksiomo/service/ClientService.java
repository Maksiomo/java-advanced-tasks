package com.maksiomo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.validation.annotation.Validated;
import com.maksiomo.model.dto.ClientDTO;
import com.maksiomo.model.domain.Client;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@Validated
public interface ClientService {
    Client createClient(ClientDTO clientData);

    Client alterClient(ClientDTO newData, @Positive Integer idClient);

    String deleteClient(@Positive Integer idClient);

    Optional<Client> getClientById(@Positive Integer idClient);

    Page<Client> getClients(Pageable pageable);

    Page<Client> listClientsByDomain(Pageable pageable, String domain);

    Page<Client> listClientsBySecondName(Pageable pageable, String secondName);

}
