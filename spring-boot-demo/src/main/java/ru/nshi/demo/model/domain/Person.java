package ru.nshi.demo.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author rassafel
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person_table")
public class Person {
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
    private LocalDate personBirthDate;

    @Version
    private Integer version = 1;
}
