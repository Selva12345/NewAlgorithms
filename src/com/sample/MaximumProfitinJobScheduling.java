package com.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumProfitinJobScheduling {
	public static void main(String[] args) {
		MaximumProfitinJobScheduling m=new MaximumProfitinJobScheduling();
		//[1,2,2,3]
		//[2,5,3,4]
		//		[3,4,1,2]
		
			System.out.println(m.jobScheduling(new int[] {1,2,2,3}, new int[] {2,5,3,4}, new int[] {3,4,1,2}));
			}
			  Map<String,Integer> dp;
			     public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
				        int n=startTime.length;
				       dp=new HashMap<>();
				       int mat[][]=new int[n][];
				       for(int i=0;i<n;i++) {
				    	   mat[i]=new int[] {startTime[i],endTime[i],profit[i]};
				       }
				       Arrays.sort(mat,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
			         int max=0;
			         for(int i=0;i<n;i++)
			         max=Math.max(justDoIt(i+1,mat[i][0],mat[i][1],mat)+mat[i][2],max);
			         
			         return max;
			     }
			    private int justDoIt(int v,int start,int end,int mat[][]){
			        String key=start+"->"+end;
			        if(dp.get(key)!=null){
			            return dp.get(key);
			        }
			        int total=0;
			        for(int i=v;i<mat.length;i++){
			            if(mat[i][0]>=end){
			               total=Math.max(justDoIt(i+1,mat[i][0],mat[i][1],mat)+mat[i][2],total);  
			            }
			           
			        }
			        dp.put(key,total);
			        return total;
			    }
}
