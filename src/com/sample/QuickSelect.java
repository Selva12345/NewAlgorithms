package com.sample;

public class QuickSelect {
	public static void main(String[] args) {
		QuickSelect qs=new QuickSelect();
		int nums[]= {3,2,1,5,6,4};
		int k=2;
		System.out.println(qs.findKthLargest(nums, k));
	}
	 public int findKthLargest(int[] nums, int k) {
	        int n=nums.length;
	        quickSelect(nums,0,n-1);
	       return n;
	      
	    }
	    private void quickSelect(int[] nums, int low,int high){
	        
	        if(low<=high){
	           int val=quickSelectAlgorithm(nums,nums[high],low,high);
	           quickSelect(nums,low,val-1);
	           quickSelect(nums,val+1,high);
	        }
	        
	    }
	    private int quickSelectAlgorithm(int[] nums,int pivot,int start,int end){
	    int left=start;
	       for(int i=start;i<end;i++) {
	    	   if(nums[i]<pivot) {
	    		  swap(nums,left++,i);
	    	   }
	       }
	       swap(nums,left,end);
	       return left;
	    }
	    private void swap(int[]nums,int i,int j){
	        int temp=nums[i];
	        nums[i]=nums[j];
	        nums[j]=temp;
	    }
}
