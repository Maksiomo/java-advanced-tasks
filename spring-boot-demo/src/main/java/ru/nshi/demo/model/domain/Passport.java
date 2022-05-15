package ru.nshi.demo.model.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author rassafel
 */
@Entity
@Data
@Table(name = "person_passport")
public class Passport {

    @Id
    private Integer id;
    @Pattern(regexp = "\\d+", message = "Должны быть только цифры!!!")
    @Size(min = 5, max = 10, message = "Минимум 5 максимум 10")
    private String serialNumber;
    private LocalDate recieveDate;
    private LocalDate birthDate;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
