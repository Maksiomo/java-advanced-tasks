package ru.nshi.demo.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.nshi.demo.controller.PersonController;
import ru.nshi.demo.model.domain.Person;
import ru.nshi.demo.model.dto.CreatePersonDto;
import ru.nshi.demo.service.PersonService;

import java.time.LocalDate;
import java.util.List;

/**
 * @author rassafel
 */
@RequiredArgsConstructor
@Slf4j
@RestController
public class PersonControllerImpl implements PersonController {
    private final PersonService service;

    @Override
    public ResponseEntity<String> createPerson(CreatePersonDto dto) {
        log.info("Received object: {}", dto);
        String person = service.createPerson(dto);
        return ResponseEntity.ok(person);
    }

    @Override
    public ResponseEntity<Page<Person>> getPersons(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Order.asc("age"));
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Person> persons = service.getPersons(pageRequest);
        return ResponseEntity.ok(persons);
    }

    @Override
    public ResponseEntity<List<Person>> getPersonsGreaterThan(Integer age) {
        List<Person> persons = service.getPersonsGreaterThan(age);
        return ResponseEntity.ok(persons);
    }

    @Override
    public ResponseEntity<Person> findById(String id, String firstName) {
        if (id.matches("\\d+")) {
            Person person = new Person(id, firstName, "SecondName", "MiddleName", 123, LocalDate.now(), 1);
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
