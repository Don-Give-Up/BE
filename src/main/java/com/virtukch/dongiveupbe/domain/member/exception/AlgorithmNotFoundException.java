package com.virtukch.dongiveupbe.domain.member.exception;

public class AlgorithmNotFoundException extends RuntimeException {
    public AlgorithmNotFoundException(String algorithm) {
        super("Algorithm not found: " + algorithm);
    }
}