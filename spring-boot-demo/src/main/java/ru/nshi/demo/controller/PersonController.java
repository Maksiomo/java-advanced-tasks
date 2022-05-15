package ru.nshi.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nshi.demo.model.domain.Person;
import ru.nshi.demo.model.dto.CreatePersonDto;

import java.util.List;

/**
 * @author rassafel
 */
@RequestMapping(PersonController.MAPPING)
public interface PersonController {
    String MAPPING = "/persons";

    @PostMapping("/create")
    @Operation(description = "Request for creating new person.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Request is ok.",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
        @ApiResponse(responseCode = "400", description = "If in fio does not contains 3 elements")
    })
    ResponseEntity<String> createPerson(@RequestBody(required = false) CreatePersonDto dto);

    @GetMapping
    ResponseEntity<Page<Person>> getPersons(@RequestParam Integer page,
                                            @RequestParam(defaultValue = "20") Integer size);

    @GetMapping("/age")
    ResponseEntity<List<Person>> getPersonsGreaterThan(@RequestParam Integer age);

    @GetMapping("/{id}")
    ResponseEntity<Person> findById(@PathVariable(required = false) String id,
                                    @RequestParam(defaultValue = "FirstName") String firstName);
}
