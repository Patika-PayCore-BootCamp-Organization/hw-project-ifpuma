package com.patika.paycore.ilkproje.exception;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(Integer id){
        super("id "+ id + " is using another table as constraint, could not execute statement!");
    }
}
