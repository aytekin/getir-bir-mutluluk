package com.example.demo.common.exception;

public class EntityAlreadyExist extends RuntimeException {

    public EntityAlreadyExist(String message) {
        super(message);
    }
}
