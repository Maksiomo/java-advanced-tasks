package com.maksiomo.repository;

import com.maksiomo.model.domain.Event;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

}
