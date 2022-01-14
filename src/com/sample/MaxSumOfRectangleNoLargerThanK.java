package com.sample;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
	public static void main(String[] args) {
		MaxSumOfRectangleNoLargerThanK m = new MaxSumOfRectangleNoLargerThanK();
		int[][] mat = { {5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4} };
		System.out.println(m.maxSumSubmatrix(mat, 8));
	}
	//[[5,-4,-3,4],[-3,-4,4,5],[5,1,5,-4]]
	//10

	 public int maxSumSubmatrix(int[][] mat, int limit) {
	       int n=mat.length;
	       int m=mat[0].length;
	        for(int i=0;i<n;i++){
	            for(int j=1;j<m;j++){
	                mat[i][j]+= mat[i][j-1];
	            }
	        }
	        int max=Integer.MIN_VALUE;
	        for(int i=0;i<n;i++){
	            int arr[]=new int[m];
	            for(int j=i;j<n;j++){
	                for(int k=0;k<m;k++){
	                    arr[k]=arr[k]+mat[j][k];
	                }
	                 max=Math.max(justDoIt(arr,limit),max);
	                if(max==limit)return limit;
	            }
	            
	        }
	        return max;
	    }
	    private int justDoIt(int arr[],int k){
	        int r=Integer.MIN_VALUE;
	    
	        for(int i=arr.length-1;i>=0;i--){
	           
	           
	                for(int j=0;j<i;j++){
	                    int f=arr[i]-arr[j];
	                   //  System.out.print(" "+arr[i]+" "+arr[j]);
	                    if((arr[i]-arr[j])<=k){
	                       
	                         r=Math.max(arr[i]-arr[j],r); 
	                    }
	                   
	                }
	               
	            
	            if(arr[i]==k)return k;
	        }
	        System.out.println();
	        return r;
	    }
}
