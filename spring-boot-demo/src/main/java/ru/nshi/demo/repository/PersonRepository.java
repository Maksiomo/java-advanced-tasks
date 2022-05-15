package ru.nshi.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.util.Streamable;
import ru.nshi.demo.model.domain.Person;

import java.util.List;

/**
 * @author rassafel
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, String>,
    PersonCustomRepository {
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    Streamable<Person> findAll();

    List<Person> findByLastNameAndFirstName(String lastName, String firstname);

    List<Person> findByAgeIsGreaterThan(Integer age);
}
