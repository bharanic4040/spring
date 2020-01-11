package com.bchennu.demo.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id){
        super("Sorry , Order not found - "+id);
    }
}
