package com.salesforce.elevatorDesign;

import java.util.Comparator;
import java.util.PriorityQueue;

class Elevator {
    private int id;
    private int currentFloor;
    private int maxFloor;
    private String status;
    private String direction;
    private PriorityQueue<Integer> upStops;
    private PriorityQueue<Integer> downStops;

    public Elevator(int id, int maxFloor) {
        this.id = id;
        this.currentFloor = 0;
        this.maxFloor = maxFloor;
        this.status = "idle";  // Can be "moving" or "idle"
        this.direction = "idle";  // Can be "up", "down" or "idle"
        this.upStops = new PriorityQueue<>();
        this.downStops = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addStop(int floor) {
        if (floor < 0 || floor > maxFloor) {
            throw new IllegalArgumentException("Floor " + floor + " is out of range for elevator " + id + ".");
        }
        if (floor > currentFloor) {
            upStops.add(floor);
            if (direction.equals("idle")) {
                direction = "up";
            }
        } else if (floor < currentFloor) {
            downStops.add(floor);
            if (direction.equals("idle")) {
                direction = "down";
            }
        }
        if (status.equals("idle")) {
            moveToNext();
        }
    }

    public void moveToNext() {
        while (!upStops.isEmpty() || !downStops.isEmpty()) {
            if (direction.equals("up") && !upStops.isEmpty()) {
                int nextFloor = upStops.poll();
                System.out.println("Elevator " + id + " moving from floor " + currentFloor + " to floor " + nextFloor + ".");
                this.status = "moving";
                this.currentFloor = nextFloor;
                System.out.println("Elevator " + id + " arrived at floor " + currentFloor + ".");
            } else if (direction.equals("down") && !downStops.isEmpty()) {
                int nextFloor = downStops.poll();
                System.out.println("Elevator " + id + " moving from floor " + currentFloor + " to floor " + nextFloor + ".");
                this.status = "moving";
                this.currentFloor = nextFloor;
                System.out.println("Elevator " + id + " arrived at floor " + currentFloor + ".");
            }

            if (upStops.isEmpty() && direction.equals("up")) {
                if (!downStops.isEmpty()) {
                    direction = "down";
                } else {
                    direction = "idle";
                    status = "idle";
                    break;
                }
            } else if (downStops.isEmpty() && direction.equals("down")) {
                if (!upStops.isEmpty()) {
                    direction = "up";
                } else {
                    direction = "idle";
                    status = "idle";
                    break;
                }
            }
        }

        if (upStops.isEmpty() && downStops.isEmpty()) {
            direction = "idle";
            status = "idle";
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public String getStatus() {
        return status;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Elevator " + id + " is at floor " + currentFloor + " and is " + status + " moving " + direction + ".";
    }
}