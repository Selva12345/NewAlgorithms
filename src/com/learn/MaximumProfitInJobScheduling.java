package com.learn;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        MaximumProfitInJobScheduling maximumProfitInJobScheduling=new MaximumProfitInJobScheduling();
        //[4,2,4,8,2]
        //[5,5,5,10,8]
        //[1,2,8,10,4]
      int[] startTime = {1,2,3,3}; int[] endTime = {3,4,5,6}; int[] profit = {50,10,40,70};
        System.out.println(maximumProfitInJobScheduling.jobScheduling(startTime,endTime,profit));
    }
    Integer dp[];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n= profit.length;
        dp=new Integer[n];
        //   Arrays.fill(dp,-1);
        int mat[][]=new int[n][3];

        for(int i=0;i<n;i++){
            mat[i][0]=startTime[i];
            mat[i][1]=endTime[i];
            mat[i][2]=profit[i];
        }
        Arrays.sort(mat,(a,b)->a[0]-b[0]);
        int a=maxProfitScheduling(mat,mat[0][1],0);

        return a;
    }
    private int maxProfitScheduling(int[][] time,int end,int index){
        if(index == time.length){
            return 0;
        }
        if(index== time.length-1){
            return time[index][2];
        }
        if(index<time.length&&dp[index]!=null){
            return dp[index];
        }
        int max=Integer.MIN_VALUE;
        int ind=binarySearch(index+1,time.length-1,time,end);

        if(ind<time.length){
            max=Math.max(maxProfitScheduling(time,time[ind][1],ind)+time[index][2],max);
        }
        max=Math.max(maxProfitScheduling(time,time[index][1],index+1),max);

        int t = max==Integer.MIN_VALUE?0:max;
        dp[index]=t;
        return t;
    }
    private int binarySearch(int low,int high,int time[][],int target){

        while(low<=high){
            int mid=low+(high-low)/2;
            if(time[mid][0]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        //   System.out.println(low);
        return low;
    }
}
