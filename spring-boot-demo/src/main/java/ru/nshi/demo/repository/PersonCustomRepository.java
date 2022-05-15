package ru.nshi.demo.repository;

import ru.nshi.demo.model.domain.Person;

/**
 * @author rassafel
 */
public interface PersonCustomRepository {
    Iterable<Person> findByAge(Integer age);
}
