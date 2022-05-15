package ru.nshi.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.nshi.demo.event.model.PassportEvent;
import ru.nshi.demo.event.publisher.PassportPublisher;
import ru.nshi.demo.mapper.PersonMapper;
import ru.nshi.demo.model.domain.Person;
import ru.nshi.demo.model.dto.CreatePersonDto;
import ru.nshi.demo.repository.PersonRepository;
import ru.nshi.demo.service.PersonService;

import java.util.List;

/**
 * @author rassafel
 */
@RequiredArgsConstructor
@Slf4j
@Service
@Validated
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final PersonMapper personMapper;
    private final PassportPublisher publisher;

    @Override
    @Transactional
    public String createPerson(CreatePersonDto dto) {
        Person person = personMapper.map(dto);
        log.info("Object: {}", person);
        repository.save(person);
        publisher.publish(PassportEvent.CREATE);
        return "Mapped and Created";
    }

    @Override
    public Page<Person> getPersons(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Person> getPersonsGreaterThan(Integer age) {
        return repository.findByAgeIsGreaterThan(age);
    }
}
