package com.bchennu.demo.service;

import com.bchennu.demo.exception.DriverNotFoundException;
import com.bchennu.demo.model.Driver;
import com.bchennu.demo.model.Order;

import java.util.List;

public abstract class AbstractLocationProvider {

    public abstract Driver findNearestDriver(Order order, List<Driver> drivers) throws DriverNotFoundException;
}
