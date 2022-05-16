package com.maksiomo.service.implementation;

import java.time.LocalDateTime;
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
import java.util.Optional;
import java.util.List;
import com.maksiomo.model.domain.Client;
import com.maksiomo.model.domain.Event;
import com.maksiomo.model.dto.ClientDTO;
import com.maksiomo.repository.ClientRepository;
import com.maksiomo.repository.EventRepository;
import com.maksiomo.service.ClientService;

@RequiredArgsConstructor
@Slf4j
@Service
@Validated
public class ClientServiceImplementation implements ClientService {
    private final ClientRepository clientRepository;
    private final EventRepository eventRepository;
    private final ClientMapper clientMapper;
    private final ClientPublisher publisher;

    @Override
    public Client createClient(ClientDTO clientData) {
        Client client = clientMapper.mapClient(clientData);
        log.info("Object: {}", client);
        clientRepository.save(client);
        eventRepository.save(new Event(client.getId(), ClientEvent.CREATE.toString(), LocalDateTime.now()));
        publisher.publish(ClientEvent.CREATE);
        return client;
    }

    @Override
    public Client alterClient(ClientDTO newData, @Positive Integer idClient) {
        Optional<Client> cOptional = clientRepository.getClientById(idClient);
        if (cOptional.isPresent()) {
            Client client = cOptional.get();
            Client tempClient = clientMapper.mapClient(newData);
            client.setBirthDate(
                    (tempClient.getBirthDate() != null) ? tempClient.getBirthDate() : client.getBirthDate());
            client.setFirstName(
                    (tempClient.getFirstName() != null) ? tempClient.getFirstName() : client.getFirstName());
            client.setLastName((tempClient.getLastName() != null) ? tempClient.getLastName() : client.getLastName());
            client.setMiddleName(
                    (tempClient.getMiddleName() != null) ? tempClient.getMiddleName() : client.getMiddleName());
            client.setPhoneNumber(
                    (tempClient.getPhoneNumber() != null) ? tempClient.getPhoneNumber() : client.getPhoneNumber());
            client.setEmail((tempClient.getEmail() != null) ? tempClient.getEmail() : client.getEmail());
            client.setGender((tempClient.getGender() != null) ? tempClient.getGender() : client.getGender());
            clientRepository.save(client);
            eventRepository.save(new Event(client.getId(), ClientEvent.ALTER.toString(), LocalDateTime.now()));
            publisher.publish(ClientEvent.ALTER);
            return client;
        }
        throw new Error("Client not found");
    }

    @Override
    public String deleteClient(@Positive Integer idClient) {
        Optional<Client> currentClient = clientRepository.getClientById(idClient);
        if (currentClient.isPresent()) {
            Client client = currentClient.get();
            client.setDeletionDate(LocalDateTime.now());
            clientRepository.save(client);
            publisher.publish(ClientEvent.DELETE);
            eventRepository.save(new Event(client.getId(), ClientEvent.DELETE.toString(), LocalDateTime.now()));
            return "Client deleted";
        }
        return "Client not found";
    }

    @Override
    public Optional<Client> getClientById(@Positive Integer idClient) {
        return clientRepository.getClientById(idClient);
    }

    @Override
    public Page<Client> getClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Page<Client> listClientsByDomain(Pageable pageable, String domain) {
        return clientRepository.listClientsByDomain(pageable, domain);
    }

}
