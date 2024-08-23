package com.salesforce.parkingLot;

import java.time.LocalDateTime;

public class ParkingSpot {
    int id;
    ParkingStatus status;
    LocalDateTime startTime;

    public ParkingSpot(int id, ParkingStatus status, LocalDateTime startTime, LocalDateTime endTime, int floor) {
        this.id = id;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.floor = floor;
    }

    LocalDateTime endTime;
    int floor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingStatus status) {
        this.status = status;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }



}
