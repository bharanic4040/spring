package com.bchennu.demo.service;

import com.bchennu.demo.model.Driver;
import com.bchennu.demo.model.Order;
import com.bchennu.demo.service.AbstractLocationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private AbstractLocationProvider locationProvider;


    public Driver allocateDriver(Order order){

       return locationProvider.findNearestDriver(order,getAllDrivers());

    }

    public List<Driver> getAllDrivers(){
        return Collections.emptyList();
    }


}
