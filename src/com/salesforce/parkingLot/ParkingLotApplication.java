package com.salesforce.parkingLot;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

public class ParkingLotApplication {
    public static void main(String[] args) {
            ParkingService parkingService=ParkingService.getInstance();
            ParkingSpot parkingSpot=new ParkingSpot(1,ParkingStatus.FREE, LocalDateTime.now(),
                    LocalDateTime.now().plusDays(3),2);
            Vehicle vehicle =new Car(1,"TN49-2456", VehicleType.LARGE);
            Ticket ticket = parkingService.parkVehicle(vehicle,parkingSpot, 1,2);
             System.out.println(ticket.toString());
            parkingService.unParkVehicle(vehicle,parkingSpot);
    }
}
