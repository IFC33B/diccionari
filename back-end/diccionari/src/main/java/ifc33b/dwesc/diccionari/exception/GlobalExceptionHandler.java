package ifc33b.dwesc.diccionari.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Palabra no encontrada
    @ExceptionHandler(ParaulaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleParaulaNotFoundException(ParaulaNotFoundException ex) {
        ErrorResponse error = ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // La palabra ya existe
    @ExceptionHandler(ParaulaAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleParaulaAlreadyExistsException(ParaulaAlreadyExistsException ex) {
        ErrorResponse error = ErrorResponse.create(ex, HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
