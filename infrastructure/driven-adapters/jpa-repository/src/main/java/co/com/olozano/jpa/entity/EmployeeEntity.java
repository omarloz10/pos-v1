package co.com.olozano.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity(name = "employees")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_number", unique = true)
    private String documentNumber;

    @Column(name = "number_phone")
    private String numberPhone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @PrePersist
    private void prePersist() {
        this.entryDate = LocalDate.now();
        this.deleted = false;
        this.age = (int) ChronoUnit.YEARS.between(this.birthdate, LocalDate.now());
    }
}
