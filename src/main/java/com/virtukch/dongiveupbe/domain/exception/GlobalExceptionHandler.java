package com.virtukch.dongiveupbe.domain.exception;

import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.security.member.exception.MemberEmailAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MemberEmailAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleMemberEmailAlreadyExistException(MemberEmailAlreadyExistException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // 각 필드별 오류 메시지를 errors 맵에 추가
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
