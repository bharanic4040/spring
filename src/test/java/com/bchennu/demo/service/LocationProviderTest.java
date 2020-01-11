package com.bchennu.demo.service;


import com.bchennu.demo.model.Address;
import com.bchennu.demo.model.Driver;
import com.bchennu.demo.model.Order;
import com.bchennu.demo.model.Vehicle;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class LocationProviderTest {

    private LocationProvider locationProvider;

    private Order order;

    private List<Driver> driverList;

    @Before
    public void setUp(){
        locationProvider=new LocationProvider();
        order = new Order(order.getUserId(),order.getRestaurantId(),order.getOrderItems());
        order.setDeliveryAddress(new Address("Mumbai","TN","India",true));
        driverList=new ArrayList<>();
        Driver driverOne = new Driver("Bharani",new Vehicle("TN07CE1692"));
        Address driverOneAddr = new Address("Bangalore","TN","India",true);
        driverOne.setCurrentLocation(driverOneAddr);
        Driver driverTwo = new Driver("Chennu",new Vehicle("TN07CE1792"));
        Address driverTwoAddr = new Address("Chennai","TN","India",true);
        driverTwo.setCurrentLocation(driverTwoAddr);
        driverList.add(driverOne);
        driverList.add(driverTwo);


    }
    @Test
    public void testFindNearestDriver(){

       Driver driver = locationProvider.findNearestDriver(order,driverList);
       assertNotNull(driver);

    }

}
