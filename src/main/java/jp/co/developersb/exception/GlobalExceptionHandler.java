package jp.co.developersb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleProductAlreadyExistsException(
            ProductAlreadyExistsException exception
    ) {
        return Map.of("message", exception.getMessage());
    }
}