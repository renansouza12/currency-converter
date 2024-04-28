package com.example.util;

public class InvalidOptionException extends RuntimeException {
    public InvalidOptionException(String message){
        super(message);
    }
}
