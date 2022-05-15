package ru.nshi.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.nshi.demo.model.domain.Person;

import java.time.LocalDate;

/**
 * @author rassafel
 */
@DataJpaTest
public class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;

    @Test
    public void testSavePerson() {
        Person p = new Person("someId",
            "firstName",
            "lastName",
            "lastName",
            18,
            LocalDate.now(),
            0);

        personRepository.save(p);
    }
}
