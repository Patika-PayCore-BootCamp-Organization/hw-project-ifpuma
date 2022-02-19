package com.patika.paycore.ilkproje.exception;

public class AlreadyExist extends RuntimeException{
    public AlreadyExist(Integer id){
        super("reservation "+id + " is taken, please choose anpther one!");
    }
}
