package com.myshopping.MyShopping.Exception;

public class UnAuthorised extends RuntimeException{
    public UnAuthorised(String message) {
        super(message);
    }
}
