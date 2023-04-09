package com.getir.project.common.exception;

public class EntityNotFound extends RuntimeException{

    public EntityNotFound() {
        super("Entity not found with given id");
    }
}
