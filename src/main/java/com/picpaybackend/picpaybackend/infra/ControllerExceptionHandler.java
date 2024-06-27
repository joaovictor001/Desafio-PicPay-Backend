package com.picpaybackend.picpaybackend.infra;

import com.picpaybackend.picpaybackend.dtos.Exceptions.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity theatDuplicateEntry(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usúario já cadastrado", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity theat404(DataIntegrityViolationException exception){
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> theatGeneralException(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.notFound().build();

    }
}

