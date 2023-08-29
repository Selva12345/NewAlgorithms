package com.uber;

import java.util.TreeMap;

public class Trips {

        public static void main(String[] args) {
            int[][] trips = {
                    {0, 5},
                    {1, 2},
                    {3, 7}
            };

            TreeMap<Integer, Integer> tripCounts = new TreeMap<>();

            // Iterate through each trip
            for (int[] trip : trips) {
                int start = trip[0];
                int end = trip[1];

                // Increment the count of trips for the start time slot
                tripCounts.put(start, tripCounts.getOrDefault(start, 0) + 1);

                // Decrement the count of trips for the end+1 time slot (exclusive)
                tripCounts.put(end + 1, tripCounts.getOrDefault(end + 1, 0) - 1);
            }

            int activeTrips = 0;
            int prevTime = -1;

            // Process the time slots and calculate the number of trips in progress
            for (int time : tripCounts.keySet()) {
                if (prevTime != -1) {
                    int tripCount = tripCounts.get(prevTime);
                    activeTrips += tripCount;
                    System.out.println("[" + prevTime + ", " + time + "] -> " + activeTrips);
                }
                prevTime = time;
            }
        }
    }

