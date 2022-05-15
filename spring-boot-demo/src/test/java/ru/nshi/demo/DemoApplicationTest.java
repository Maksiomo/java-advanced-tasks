package ru.nshi.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.nshi.demo.controller.impl.PersonControllerImpl;
import ru.nshi.demo.model.dto.CreatePersonDto;
import ru.nshi.demo.service.PersonService;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoApplicationTest {

    @Mock
    PersonService personService;

    @InjectMocks
    PersonControllerImpl personController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void contextLoads() {
        CreatePersonDto dto = new CreatePersonDto();
        dto.setId("ID");

        Mockito.when(personService.createPerson(dto))
            .thenReturn("Created");

        ResponseEntity<String> person = personController.createPerson(dto);
        assertThat(person)
            .extracting("body", "status")
            .containsExactly("Created", HttpStatus.OK);

    }

}
