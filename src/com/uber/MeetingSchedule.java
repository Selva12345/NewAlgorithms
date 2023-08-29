package com.uber;
import java.io .*;
import java.util .*;
public class MeetingSchedule {


/**
 Build an API that can schedule meetings in a predefined set of conference rooms.
 It should have a method like scheduleMeeting(startTime, endTime) which returns any available room at that time and reserves it or an error if no rooms are available.
 **/

    /**
     * number of rooms = 2
     * <p>
     * (1, 5) -> 0
     * (2, 3) -> 1
     * (3, 5) -> 1
     * (1, 3) -> -1 / error
     * (4, 6) -> -1
     * (6, 8) -> 0
     **/

// Main class should be named 'Solution' and should not be public.
    static int meetingRooms;
    static int room;
    static List<Map<Integer, Integer>> slots;

    public static void main(String[] args) {
        System.out.println("Result");
        meetingRooms = 3;
        room = 0;
        slots = new ArrayList<>();
        System.out.println(scheduleMeeting(1, 5));
        System.out.println(scheduleMeeting(2, 3));
        System.out.println(scheduleMeeting(3, 5));
        System.out.println(scheduleMeeting(1, 3));
    }

    public static int scheduleMeeting(int startTime, int endTime) {

        if (startTime < 0 || endTime < 0) {
            return -1;
        }


        if (meetingRooms > room) {
            Map<Integer, Integer> time = new HashMap<>();
            time.put(startTime, endTime);
            slots.add(time);
            return room++;
        }
        // System.out.println(slots);
        int count = 0;
        for (Map<Integer, Integer> time : slots) {
            for (int start : time.keySet()) {
                int end = time.get(start);
                if (startTime > end) {
                    Map<Integer, Integer> tr = slots.get(count);
                    tr.put(startTime, endTime);
                    return count;
                } else if (endTime < start) {
                    Map<Integer, Integer> tr = slots.get(count);
                    tr.put(startTime, endTime);
                    return count;
                } else if (start <= startTime && end <= endTime) {
                    count++;
                    continue;
                } else if (startTime <= start && end >= endTime) {
                    count++;
                    continue;
                }

            }
        }
        return -1;

    }
}