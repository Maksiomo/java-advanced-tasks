package com.maksiomo.repository;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.util.Streamable;

import java.util.Optional;

import com.maksiomo.model.domain.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
    Streamable<Client> getClients(Pageable pageable);

    Optional<Client> getClientById(Integer idClient);

    Page<Client> listClientsByDomain(Pageable pageable, String domain);
}