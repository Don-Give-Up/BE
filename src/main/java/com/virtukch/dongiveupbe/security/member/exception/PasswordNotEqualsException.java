package com.virtukch.dongiveupbe.security.member.exception;

public class PasswordNotEqualsException extends RuntimeException {

    public PasswordNotEqualsException(String message) {
        super(message);
    }
}