package co.com.olozano.api.config;


import co.com.olozano.model.exceptions.BadRequestResponse;
import co.com.olozano.model.exceptions.ExceptionHandlerResponse;
import co.com.olozano.model.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<BadRequestResponse> badRequestValidationError(MethodArgumentNotValidException exception) {

        Set<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toSet());

        BadRequestResponse response = BadRequestResponse.builder()
                .status("ERROR")
                .statusCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .code(HttpStatus.BAD_REQUEST.name())
                .validationErrors(errors)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionHandlerResponse> notFoundException(
            NotFoundException exception
    ) {
        ExceptionHandlerResponse exceptionHandlerResponse = ExceptionHandlerResponse.builder()
                .status("ERROR")
                .statusCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionHandlerResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionHandlerResponse> internalServerError(Exception exception) {

        ExceptionHandlerResponse exceptionHandlerResponse = ExceptionHandlerResponse.builder()
                .status("ERROR")
                .statusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .code(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message(exception.getClass().getName())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionHandlerResponse, HttpStatus.NOT_FOUND);
    }
}
