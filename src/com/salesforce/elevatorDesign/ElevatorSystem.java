package com.salesforce.elevatorDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class ElevatorSystem {
    private List<Elevator> elevators;
    private int maxFloor;

    public ElevatorSystem(int maxFloor) {
        this.elevators = new ArrayList<>();
        this.maxFloor = maxFloor;
    }

    public void addElevator(Elevator elevator) {
        if (elevators.size() >= 100) {
            throw new IllegalStateException("Cannot add more than 100 elevators.");
        }
        elevators.add(elevator);
        System.out.println("Elevator " + elevator + " added to the system.");
    }

    public void requestElevator(int floor, String direction) {
        if (floor < 0 || floor > maxFloor) {
            throw new IllegalArgumentException("Floor " + floor + " is out of range.");
        }

        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;
        TreeSet<Integer> allNearestElevators=new TreeSet<>();
        for (Elevator elevator : elevators) {
            if (elevator.getStatus().equals("idle")) {
                int distance = Math.abs(elevator.getCurrentFloor() - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            } else if (elevator.getDirection().equals(direction)) {
                if ((direction.equals("up") && elevator.getCurrentFloor() <= floor) ||
                        (direction.equals("down") && elevator.getCurrentFloor() >= floor)) {
                    int distance = Math.abs(elevator.getCurrentFloor() - floor);
                    if (distance < minDistance) {
                        minDistance = distance;
                        bestElevator = elevator;
                    }
                }
            }
        }

        if (bestElevator != null) {
            System.out.println("Elevator " + bestElevator + " is the nearest suitable elevator.");
            bestElevator.addStop(floor);
        } else {
            System.out.println("No suitable elevators available.");
        }
    }

    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(10);

        Elevator elevator1 = new Elevator(1, 10);
        Elevator elevator2 = new Elevator(2, 10);

        system.addElevator(elevator1);
        system.addElevator(elevator2);

        system.requestElevator(5, "up");
        system.requestElevator(2, "down");
        system.requestElevator(8, "up");
        system.requestElevator(3, "down");
    }
}