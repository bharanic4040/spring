package com.bchennu.demo.model;

public class Driver extends BaseEntity{

    private String name;
    private Vehicle vehicle;

    private Address currentLocation;
    private boolean isOperating;  //he may be out of service for a while

    public Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Address getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Address currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isOperating() {
        return isOperating;
    }

    public void setOperating(boolean operating) {
        isOperating = operating;
    }
}
