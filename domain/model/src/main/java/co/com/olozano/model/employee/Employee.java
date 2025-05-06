package co.com.olozano.model.employee;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Employee {

    private UUID id;
    private String name;
    private String lastname;
    private Integer age;
    private String documentType;
    private String documentNumber;
    private String numberPhone;
    private String email;
    private String address;
    private String gender;
    private LocalDate birthdate;
    private LocalDate entryDate;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
