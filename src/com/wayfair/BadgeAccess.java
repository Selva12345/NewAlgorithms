package com.wayfair;

import java.util.*;

public class BadgeAccess {
    /*
    * We are working on a security system for a badged-access room in our company's building.
Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:
All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit.
(All employees are required to leave the room before the log ends.)
All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter.
 (The room is empty when the log begins.)
Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.
    * */
    public static void main(String[] args) {
        BadgeAccess badgeAccess=new BadgeAccess();
        String[][] arr = {{"Paul", "enter"},{"Pauline", "exit"},{"Paul", "enter"},{"Paul", "exit"},
                          {"Martha", "exit"},{"Joe", "enter"}, {"Martha", "enter"}, {"Steve", "enter"}, {"Martha", "exit"},
                          {"Jennifer", "enter"}, {"Joe", "enter"}, {"Curtis", "exit"}, {"Curtis", "enter"}, {"Joe", "exit"},
                          {"Martha", "enter"},{"Martha", "exit"}, {"Jennifer", "exit"}, {"Joe", "enter"},{"Joe", "enter"},
                          {"Martha", "exit"},{"Joe", "exit"},{"Joe", "exit"}};

        System.out.println(badgeAccess.collectAccess(arr));
    }

    private  List<List<String>> collectAccess(String[][] arr) {
        List<List<String>> result=new ArrayList<>();
        Set<String> entry=new HashSet<>();
        Set<String> exit=new HashSet<>();
        Map<String,String> count = new HashMap<>();
        for(int i=0;i<arr.length;i++){
                String s[]=arr[i];
                if(s[1].equals("enter") && !count.containsKey(s[0])){
                    count.put(s[0],s[1]);
                }else if(s[1].equals("enter") ){
                    entry.add(s[0]);
                }

                if(s[1].equals("exit") && count.containsKey(s[0])){
                    count.remove(s[0]);
                }else if(s[1].equals("exit")){
                    exit.add(s[0]);
                }

        }
        for(String key:count.keySet()){
                if(count.get(key).equals("entry")){
                    exit.add(key);
                }else{
                   entry.add(key);
                }
        }
        result.add(new ArrayList<>(entry));
        result.add(new ArrayList<>(exit));
        return result;
    }
}














