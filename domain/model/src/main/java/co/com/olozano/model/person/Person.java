package co.com.olozano.model.person;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Person {

    private UUID id;
    private String name;
    private String lastname;
    private Integer age;
    private String documentType;
    private String documentNumber;
    private String numberPhone;
    private String email;
    private LocalDate birthdate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
