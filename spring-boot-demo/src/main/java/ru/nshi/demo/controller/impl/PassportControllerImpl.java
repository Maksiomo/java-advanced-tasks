package ru.nshi.demo.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.nshi.demo.controller.PassportController;
import ru.nshi.demo.model.domain.Passport;

/**
 * @author rassafel
 */
@RequiredArgsConstructor
@RestController
public class PassportControllerImpl implements PassportController {


    @Override
    public String createPassport(Passport passport) {
        return "Ok";
    }
}
