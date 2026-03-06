package com.example.patient_service.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.patient_service.controller.PatientController;
import com.example.patient_service.service.PatientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final PatientController patientController;
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    GlobalExceptionHandler(PatientController patientController) {
        this.patientController = patientController;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);

    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handlemailALreadtExistsException(EmailAlreadyExistsException ex) {

        log.warn("email address already sued {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "email addressalready exists");
        return ResponseEntity.badRequest().body(errors);

    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlepatientNotFoundException(PatientNotFoundException ex) {
        log.warn("ID not found {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "patient id not found exists");
        return ResponseEntity.badRequest().body(errors);

    }

}
