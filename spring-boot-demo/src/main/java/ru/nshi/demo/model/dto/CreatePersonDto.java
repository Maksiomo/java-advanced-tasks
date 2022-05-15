package ru.nshi.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author rassafel
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreatePersonDto {
    private String id;
    private String fio;
    private Integer rawAge;
    private String birthDate;
}
