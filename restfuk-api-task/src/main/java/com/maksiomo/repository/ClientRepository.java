package com.maksiomo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

import com.maksiomo.model.domain.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
    Page<Client> getClients(Pageable pageable);

    Optional<Client> getClientById(Integer idClient);

    Page<Client> listClientsByDomain(Pageable pageable, String domain);

    Page<Client> listClientsBySecondName(Pageable pageable, String secondName);
}