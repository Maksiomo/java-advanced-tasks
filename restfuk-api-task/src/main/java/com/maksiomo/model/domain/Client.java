package com.maksiomo.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_data")
public class Client {
    @Id
    @Column(name = "id", length = 8)
    private Integer id;
    @Pattern(regexp = "[\\-А-Яа-яЁё]+", message = "invalid symbol in first name")
    @Column(name = "first_name", length = 32, nullable = false)
    private String firstName;
    @Pattern(regexp = "[\\-А-Яа-яЁё]+", message = "invalid symbol in last name")
    @Column(name = "last_name", length = 32, nullable = false)
    private String lastName;
    @Pattern(regexp = "[\\-А-Яа-яЁё]+", message = "invalid symbol in middle name")
    @Column(name = "middle_name", length = 32, nullable = false)
    private String middleName;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Pattern(regexp = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$", message = "invalid symbol in phone number")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Email
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;
    @Column(name = "deletion_date")
    private LocalDateTime deletionDate;
}
