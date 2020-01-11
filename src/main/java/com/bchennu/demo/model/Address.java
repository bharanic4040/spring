package com.bchennu.demo.model;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

public class Address extends BaseEntity {

    private String city;
    private String state;
    private String country;
    private boolean isPrimary;

    public Address(String city, String state, String country, boolean isPrimary) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.isPrimary = isPrimary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
}
