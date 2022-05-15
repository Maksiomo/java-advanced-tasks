package ru.nshi.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import ru.nshi.demo.model.domain.Person;
import ru.nshi.demo.model.dto.CreatePersonDto;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author rassafel
 */
@Validated
public interface PersonService {
    String createPerson(CreatePersonDto dto);

    Page<Person> getPersons(Pageable pageable);

    List<Person> getPersonsGreaterThan(@Positive Integer age);
}
