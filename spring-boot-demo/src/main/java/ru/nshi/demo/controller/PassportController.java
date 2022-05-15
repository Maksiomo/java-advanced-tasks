package ru.nshi.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nshi.demo.model.domain.Passport;

import javax.validation.Valid;

/**
 * @author rassafel
 */
@RequestMapping("/passport")
public interface PassportController {

    @PostMapping("/create")
    String createPassport(@RequestBody @Valid Passport passport);

}
