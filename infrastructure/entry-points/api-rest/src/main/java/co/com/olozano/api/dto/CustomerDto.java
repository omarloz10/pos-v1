package co.com.olozano.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerDto(
        UUID customerId,
        UUID personId,

        @NotNull(message = "The field name is required")
        @NotBlank(message = "The field name is required")
        @NotEmpty(message = "The field name is required")
        String name,

        @NotNull(message = "The field lastname is required")
        @NotBlank(message = "The field lastname is required")
        @NotEmpty(message = "The field lastname is required")
        String lastname,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Integer age,

        @NotNull(message = "The field documentType is required")
        @NotBlank(message = "The field documentType is required")
        @NotEmpty(message = "The field documentType is required")
        String documentType,

        @NotNull(message = "The field documentNumber is required")
        @NotBlank(message = "The field documentNumber is required")
        @NotEmpty(message = "The field documentNumber is required")
        String documentNumber,

        @NotNull(message = "The field numberPhone is required")
        @NotBlank(message = "The field numberPhone is required")
        @NotEmpty(message = "The field numberPhone is required")
        String numberPhone,

        @NotNull(message = "The field email is required")
        @NotBlank(message = "The field email is required")
        @NotEmpty(message = "The field email is required")
        @Email(message = "The field email is invalid")
        String email,

        @NotNull(message = "The field address is required")
        @NotBlank(message = "The field address is required")
        @NotEmpty(message = "The field address is required")
        @Email(message = "The field address is invalid")
        String address,

        @NotNull(message = "The field gender is required")
        @NotBlank(message = "The field gender is required")
        @NotEmpty(message = "The field gender is required")
        @Email(message = "The field gender is invalid")
        String gender,

        @NotNull(message = "The field birthdate is required")
        @NotBlank(message = "The field birthdate is required")
        @NotEmpty(message = "The field birthdate is required")
        LocalDate birthdate,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        boolean deleted
) {
}
