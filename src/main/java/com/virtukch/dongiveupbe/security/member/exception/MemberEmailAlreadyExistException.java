package com.virtukch.dongiveupbe.security.member.exception;

public class MemberEmailAlreadyExistException extends RuntimeException {

    public MemberEmailAlreadyExistException(String message) {
        super(message);
    }
}