package com.salesforce.parkingLot;

abstract class Vehicle {
    int id;
    String registeredNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    Vehicle(int id, String registeredNumber){
        this.id=id;
        this.registeredNumber=registeredNumber;
    }

}
