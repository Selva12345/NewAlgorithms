package com.salesforce.parkingLot;

import java.time.LocalDateTime;

public class Ticket {
    int id;
    int floor;
    int parkingSpotId;
    int parkingLotId;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public Ticket(int id, int floor, int parkingSpotId, int parkingLotId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.floor = floor;
        this.parkingSpotId = parkingSpotId;
        this.parkingLotId = parkingLotId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
    @Override
    public String toString(){
        return " Id: "+id+" Floor: "+floor+" Parking Lot Id: "+parkingLotId+" Parking Spot Id: "
                +parkingSpotId+ "\n" +
                " Start Time: "+startTime+" End Time: "+endTime.toString();
    }
}
