package com.salesforce.parkingLot;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingService implements IParkingService{
    static Map<Integer, Vehicle> parking =new HashMap<>();
    private static ParkingService parkingService;
    private ParkingService(){

    }

    public static ParkingService getInstance() {
        parkingService=new ParkingService();
        return  parkingService;
    }

    @Override
    public Ticket parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot, int parkingLotId, int floorId) {
        if(parking.containsKey(parkingSpot.getId())){
            throw new IllegalArgumentException("Already Parked");
        }
        Ticket ticket =getTicket(vehicle,parkingSpot,parkingLotId, floorId);
        parking.put(parkingSpot.getId(),vehicle);
        System.out.println("Vehicle Parked Digitally, Get your ticket");
        return ticket;
    }

    private Ticket getTicket(Vehicle vehicle,ParkingSpot parkingSpot, int parkingLotId, int floorId) {
        System.out.println("Getting Ticket");
        Ticket ticket=new Ticket(1,floorId,parkingSpot.getId(),parkingLotId,
                parkingSpot.getStartTime(),parkingSpot.getEndTime());
        return ticket;
    }

    @Override
    public String unParkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        if(!parking.containsKey(parkingSpot.getId())){
            throw new IllegalArgumentException("Given spot is Empty");
        }
        parking.remove(parkingSpot.getId());
        return "Successfully UnParked";
    }
}
