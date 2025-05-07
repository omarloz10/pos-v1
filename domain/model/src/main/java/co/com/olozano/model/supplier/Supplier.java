package co.com.olozano.model.supplier;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class Supplier {
    private UUID id;
    private String nit;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
