package com.bchennu.demo.service;

import com.bchennu.demo.exception.DriverNotFoundException;
import com.bchennu.demo.model.Driver;
import com.bchennu.demo.model.Location;
import com.bchennu.demo.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/*
Basic Geocoding API and also this class calculates the minimum distance driver of all the drivers
 */
@Service
public class BasicLocationProvider extends AbstractLocationProvider{


    private static final double LEFT_LIMIT= -50d;
    private static final double RIGHT_LIMIT = 50d;

    public Driver findNearestDriver(Order order, List<Driver> drivers) throws DriverNotFoundException{

        if(drivers.size()==0){
            throw new DriverNotFoundException();
        }
        Location orderLocation = getLocationFromAddress(order.getDeliveryAddress().getCity(),
                order.getDeliveryAddress().getState(),order.getDeliveryAddress().getCountry());

        Driver minDriver = drivers.get(0);
        Location driverLocation = getLocationFromAddress(minDriver.getCurrentLocation().getCity(),
                minDriver.getCurrentLocation().getState(),
                minDriver.getCurrentLocation().getCountry()
                );


        double minDistance = findDistance(orderLocation.getLatitude(),orderLocation.getLongitude(),
                                  driverLocation.getLatitude(),driverLocation.getLongitude(), "K"
        );

         double distance=Double.MIN_VALUE;

        for(Driver driver: drivers){

            Location driverLocationTmp = getLocationFromAddress(minDriver.getCurrentLocation().getCity(),
                    driver.getCurrentLocation().getState(),
                    driver.getCurrentLocation().getCountry()
            );
           distance = findDistance(orderLocation.getLatitude(),orderLocation.getLongitude(),
                   driverLocationTmp.getLatitude(),driverLocationTmp.getLongitude(), "K");

           if(distance<minDistance){
               minDistance=distance;
               minDriver=driver;
           }

        }
        return minDriver;

    }

    //method to find distance between any 2 lat/long points
    private static double findDistance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

    //method to fetch lat/lon from an address, for now generating random lat/long values
    private static Location getLocationFromAddress(String city ,String state,String country){
        return new Location(genRandomDoubleForGeocoding(),genRandomDoubleForGeocoding());

    }

    private static double genRandomDoubleForGeocoding() {
        double generatedDouble = LEFT_LIMIT + new Random().nextDouble() * (RIGHT_LIMIT - LEFT_LIMIT);
        return generatedDouble;
    }

}
