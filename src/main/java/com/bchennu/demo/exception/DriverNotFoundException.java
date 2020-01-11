package com.bchennu.demo.exception;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(){
        super("Driver can't be allocated , all drivers busy !");
    }
}
