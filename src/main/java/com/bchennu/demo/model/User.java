package com.bchennu.demo.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class User extends BaseEntity{

    private String name;

    private List<Address> addressList;

    public User(String name, Address address) {
        this.name = name;
        this.addressList=new ArrayList<>();
        address.setPrimary(true);
        this.addressList.add(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Address> getAddressList() {
        return addressList;
    }

    public void addToAddressList(Address address) {
        this.addressList.add(address);
    }
}
