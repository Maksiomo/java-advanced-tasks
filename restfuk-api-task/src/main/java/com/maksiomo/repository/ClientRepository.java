package com.maksiomo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.util.Streamable;

import java.util.Optional;

import com.maksiomo.model.domain.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
    Streamable<Client> findAll();

    Optional<Client> findById(Integer idClient);

    Page<Client> findByEmailContaining(Pageable pageable, String domain);
}