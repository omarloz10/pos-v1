package co.com.olozano.model.exceptions;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;

@Builder(toBuilder = true)
public record BadRequestResponse(
        String status,
        String statusCode,
        String code,
        Set<String> validationErrors,
        LocalDateTime timestamp
) {
}
