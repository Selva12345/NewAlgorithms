package com.salesforce.parkingLot;

import java.util.List;

public class Floor {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    List<ParkingSpot> parkingSpotList;

    Floor(int id,  List<ParkingSpot> parkingSpotList){
        this.id=id;
        this.parkingSpotList=parkingSpotList;
    }
}
