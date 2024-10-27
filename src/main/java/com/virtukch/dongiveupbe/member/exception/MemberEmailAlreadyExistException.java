package com.virtukch.dongiveupbe.member.exception;

public class MemberEmailAlreadyExistException extends RuntimeException {

    public MemberEmailAlreadyExistException(String message) {
        super(message);
    }
}