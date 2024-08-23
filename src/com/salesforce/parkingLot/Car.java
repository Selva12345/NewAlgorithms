package com.salesforce.parkingLot;

public class Car extends Vehicle{
    VehicleType vehicleType;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    Car(int id, String registeredNumber, VehicleType vehicleType) {
        super(id, registeredNumber);
        this.vehicleType=vehicleType;
    }
}
