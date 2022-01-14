package com.sample;

import java.util.Arrays;

public class FriendsOfAppropriateAges {
	public static void main(String[] args) {
		FriendsOfAppropriateAges f=new FriendsOfAppropriateAges();
		System.out.println(f.numFriendRequests(new int[] {6,26,15,30,6}));
	}

	public int numFriendRequests(int[] ages) {
	        Arrays.sort(ages);
	        int n=ages.length;
	       
	        int count=0,m=1,i=0;
	        while(i<n){
	           while(i+1<n&&ages[i]==ages[i+1]) {
	        	   m++;
	        	   i++;
	           }
	            if(i==0) {
	            	i++;
	            	continue;
	            }
	            double value=ages[i]*1.0;
	            double cur=((0.5*value)+7);
	            double prev=ages[i-1]*1.0;
	            if(prev<=cur||prev>value||(prev>100&&value<100)){
	            	i++;
	            	m=1;
	                continue;
	            }else{
	                int pos=binarySearch(cur,ages,i);
	                count+=m*(i-pos);
	            }
	            m=1;
	           i++; 
	        }
	       
	       
	        return count;
	    }

	private int binarySearch(double cur, int[] ages, int n) {

		int low = 0, high = n-1	;

		while (low <=high) {
			int mid = low + (high - low) / 2;

			if (ages[mid] <= cur) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		return low;
	}
}
