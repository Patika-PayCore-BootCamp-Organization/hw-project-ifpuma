package com.patika.paycore.ilkproje.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message + " not found!");
    }
}
