package com.maksiomo.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_data")
public class Client {
    @Id
    @Column(name = "id", length = 8)
    private String id;
    @Column(name = "first_name", length = 32)
    private String firstName;
    @Column(name = "last_name", length = 32)
    private String lastName;
    @Column(name = "middle_name", length = 32)
    private String middleName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "birthdate")
    private LocalDate clientBirthDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Column(name = "deletion_date")
    private LocalDate deletionDate;

    @Version
    private Integer version = 1;
}
