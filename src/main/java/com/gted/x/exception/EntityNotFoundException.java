package com.gted.x.exception;

/**
 * Created by Вадим on 02.10.2017.
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() { }

    public EntityNotFoundException(String s) {
        super(s);
    }

}