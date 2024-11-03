package com.virtukch.dongiveupbe.domain.member.exception;

public class PasswordNotEqualsException extends RuntimeException {

    public PasswordNotEqualsException(String message) {
        super(message);
    }
}