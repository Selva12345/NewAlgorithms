package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
	public static void main(String[] args) {
		Sum3 s=new Sum3();
		System.out.println(s.threeSum(new int[] {-1,0,1,2,-1,-4}));
	}

	 public List<List<Integer>> threeSum(int[] nums) {
	        int n=nums.length;
	        List<List<Integer>> ans=new ArrayList<>();
	        Arrays.sort(nums);
	        for(int i=0;i<n;i++){
	        	if(i>0&&nums[i]==nums[i-1])continue;
	            for(int j=i+1;j<n;j++){
	               
	                
	                int r=0-(nums[i]+nums[j]);
	                int low=j+1;
	                int high=n-1;
	                
	                while(low<=high){
	                    int mid=low+(high-low)/2;
	                    
	                    if(r==nums[mid]){
	                        ans.add(Arrays.asList(nums[i],nums[j],nums[mid]));
	                        break;
	                    }
	                    if(r>nums[mid]){
	                        low=mid+1;
	                    }else{
	                        high=mid-1;
	                    }
	                    
	                }
	            }
	        }
	        return ans;
	    }
}
