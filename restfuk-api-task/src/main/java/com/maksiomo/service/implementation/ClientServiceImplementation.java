package com.maksiomo.service.implementation;

import java.util.List;

import javax.validation.constraints.Positive;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import com.maksiomo.event.model.ClientEvent;
import com.maksiomo.event.publisher.ClientPublisher;
import com.maksiomo.mapper.ClientMapper;
import java.util.List;
import com.maksiomo.model.domain.Client;
import com.maksiomo.model.dto.ClientDTO;
import com.maksiomo.repository.ClientRepository;
import com.maksiomo.service.ClientService;

@RequiredArgsConstructor
@Slf4j
@Service
@Validated
public class ClientServiceImplementation implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ClientPublisher publisher;

    @Override
    public Client createClient(ClientDTO clientData) {
        Client client = clientMapper.map(clientData);
        log.info("Object: {}", client);
        clientRepository.save(client);
        publisher.publish(ClientEvent.CREATE);
        return client;
    }

    @Override
    public Client alterClient(ClientDTO newData, @Positive Integer idClient) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String deleteClient(@Positive Integer idClient) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client getClientById(@Positive Integer idClient) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Client> getClients(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Client> listClientsByDomain(Pageable pageable, String domain) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Client> listClientsBySecondName(Pageable pageable, String secondName) {
        // TODO Auto-generated method stub
        return null;
    }

}
