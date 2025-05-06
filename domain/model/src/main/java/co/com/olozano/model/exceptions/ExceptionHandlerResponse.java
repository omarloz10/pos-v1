package co.com.olozano.model.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record ExceptionHandlerResponse(
        String status,
        String statusCode,
        String code,
        String message,
        LocalDateTime timestamp
) {
}
