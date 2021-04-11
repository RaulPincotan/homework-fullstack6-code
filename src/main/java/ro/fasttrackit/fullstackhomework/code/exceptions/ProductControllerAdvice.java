package ro.fasttrackit.fullstackhomework.code.exceptions;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiError handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ApiError(exception.getMessage());
    }
}

@Value
class ApiError {
    String message;
}