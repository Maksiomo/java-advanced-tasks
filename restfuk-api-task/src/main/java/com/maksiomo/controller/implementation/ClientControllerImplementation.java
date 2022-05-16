package com.maksiomo.controller.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.maksiomo.controller.ClientController;
import com.maksiomo.model.domain.Client;
import com.maksiomo.model.dto.ClientDTO;
import com.maksiomo.service.ClientService;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
public class ClientControllerImplementation implements ClientController {
    private final ClientService clientService;

    @Override
    public ResponseEntity<Client> createClient(ClientDTO clientInfo) {
        log.info("Received object: { }", clientInfo);
        Client client = clientService.createClient(clientInfo);
        return ResponseEntity.ok(client);
    }

    @Override
    public ResponseEntity<Client> alterClient(ClientDTO newData, Integer idClient) {
        log.info("Received object: { }", newData);
        Client client = clientService.alterClient(newData, idClient);
        return ResponseEntity.ok(client);
    }

    @Override
    public ResponseEntity<String> deleteClient(Integer idClient) {
        return ResponseEntity.ok(clientService.deleteClient(idClient));
    }

    @Override
    public ResponseEntity<Page<Client>> getClients(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Client> clients = clientService.getClients(pageRequest);
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<Page<Client>> listClientsByDomain(Integer page, Integer size, String domain) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Client> clients = clientService.listClientsByDomain(pageRequest, domain);
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<Page<Client>> listClientsBySecondName(Integer page, Integer size, String secondName) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Client> clients = clientService.listClientsBySecondName(pageRequest, secondName);
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<Client> getClientById(Integer idClient) {
        return ResponseEntity.of(clientService.getClientById(idClient));
    }

}
