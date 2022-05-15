package com.maksiomo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import com.maksiomo.model.domain.Gender;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private String fullName;
    private Integer age;
    private String birthDate;
    private Gender gender;
    private String email;
    private String phoneNumber;
}
