package co.com.olozano.model.employee;

import co.com.olozano.model.person.Person;
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
    private Person person;
    private LocalDate entryDate;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
