package com.maksiomo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import com.maksiomo.model.dto.ClientDTO;
import com.maksiomo.model.domain.Client;

import javax.validation.constraints.Positive;
import java.util.List;

@Validated
public interface ClientService {
    Client createClient(ClientDTO clientData);

    Client alterClient(ClientDTO newData, @Positive Integer idClient);

    String deleteClient(@Positive Integer idClient);

    Client getClientById(@Positive Integer idClient);

    List<Client> getClients(Pageable pageable);

    List<Client> listClientsByDomain(Pageable pageable, String domain);

    List<Client> listClientsBySecondName(Pageable pageable, String secondName);

}
