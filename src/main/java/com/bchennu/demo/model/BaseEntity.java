package com.bchennu.demo.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


public abstract class BaseEntity implements Serializable {

    private static final AtomicLong idCounter=new AtomicLong();

    Long id;


    public BaseEntity(){
       this.id=idCounter.getAndIncrement();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
