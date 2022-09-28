package com.learn;

import java.util.Arrays;

public class LargestTimeForGivenDigits {
    public static void main(String[] args) {
        LargestTimeForGivenDigits l=new LargestTimeForGivenDigits();
        System.out.println(l.largestTimeFromDigits(new int[]{0,0,0,0}));
    }
    int result = 0;
    String ans="";
    public String largestTimeFromDigits(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int val[] = new int[4];
        Arrays.fill(val, -1);
        largestTime(arr, sb, new boolean[4], val, 0);
        if(ans.equals(""))return "";
        String result= ans.substring(0,2)+":"+ans.substring(2,4);
        return result;
    }

    private void largestTime(int[] arr, StringBuilder sb, boolean visited[], int val[], int pos) {

        if (pos == 4) {
            if (sb.length() == 4) {
                Integer value = Integer.parseInt(sb.toString());
                if (value > result) {
                    result = value;
                    ans=sb.toString();
                }
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {

            if (visited[i] == true) continue;

            if (pos == 0 && arr[i] < 3) {
                sb.append(arr[i]);
            } else if (pos == 1 && arr[i] < 4 && sb.charAt(0) == '2') {
                sb.append(arr[i]);
            } else if (pos == 1 && arr[i] <= 9 && sb.charAt(0) != '2') {
                sb.append(arr[i]);
            } else if (pos == 2 && arr[i] <= 5) {
                sb.append(arr[i]);
            } else if (pos == 3 && arr[i] <= 9) {
                sb.append(arr[i]);
            }else{
                continue;
            }
                 System.out.println(sb);
            visited[i] = true;
            largestTime(arr, sb, visited, val, pos + 1);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
