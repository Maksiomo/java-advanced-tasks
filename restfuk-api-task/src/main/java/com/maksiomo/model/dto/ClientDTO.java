package com.maksiomo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maksiomo.model.domain.Gender;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    @NotNull
    @JsonProperty("id")
    private String id;
    @NotNull
    @JsonProperty("first_name")
    private String firstName;
    @NotNull
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("middle_name")
    private String middleName;
    @NotNull
    @JsonProperty("birth_date")
    private String birthDate;
    @NotNull
    @JsonProperty("phone")
    private String phone;
    @NotNull
    @JsonProperty("email")
    private String email;
    @NotNull
    @JsonProperty("gender")
    private String gender;
    @NotNull
    @JsonProperty("phone_number")
    private String phoneNumber;
}
