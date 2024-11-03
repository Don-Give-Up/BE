package com.virtukch.dongiveupbe.domain.member.exception;

public class MemberEmailAlreadyExistException extends RuntimeException {

    public MemberEmailAlreadyExistException(String message) {
        super(message);
    }
}