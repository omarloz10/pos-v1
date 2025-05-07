package co.com.olozano.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record SupplierDto(
        UUID id,

        @NotEmpty(message = "The field NIT is required")
        @NotBlank(message = "The field NIT is required")
        @NotEmpty(message = "The field NIT is required")
        String nit,

        @NotEmpty(message = "The field name is required")
        @NotBlank(message = "The field name is required")
        @NotEmpty(message = "The field name is required")
        String name,

        @NotEmpty(message = "The field phoneNumber is required")
        @NotBlank(message = "The field phoneNumber is required")
        @NotEmpty(message = "The field phoneNumber is required")
        String phoneNumber,

        @NotEmpty(message = "The field email is required")
        @NotBlank(message = "The field email is required")
        @NotEmpty(message = "The field email is required")
        @Email(message = "The field email is invalid")
        String email,

        @NotEmpty(message = "The field address is required")
        @NotBlank(message = "The field address is required")
        @NotEmpty(message = "The field address is required")
        String address,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        boolean deleted
) {
}
