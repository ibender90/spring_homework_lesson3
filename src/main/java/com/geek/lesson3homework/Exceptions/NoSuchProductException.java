package com.geek.lesson3homework.Exceptions;

public class NoSuchProductException extends Throwable{
    private final String message = "Product with given id does not exist";

    public String getMessage(){
        return message;
    }
}
