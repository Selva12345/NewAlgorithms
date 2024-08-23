package com.salesforce.parkingLot;

public interface IParkingService {
    public Ticket parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot,int parkingLotId, int floorId);
    public String unParkVehicle(Vehicle vehicle, ParkingSpot parkingSpot);

}
