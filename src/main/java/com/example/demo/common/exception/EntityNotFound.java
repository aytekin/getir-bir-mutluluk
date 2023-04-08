package com.example.demo.common.exception;

public class EntityNotFound extends RuntimeException{

    public EntityNotFound() {
        super("Entity not found with given id");
    }
}
