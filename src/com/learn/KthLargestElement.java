package com.learn;

public class KthLargestElement {

    public static void main(String[] args) {
        KthLargestElement m=new KthLargestElement();
        m.findKthLargest(new int[]{3,2,1,5,6,4},2);

    }
    static int ans=0;
    public int findKthLargest(int[] nums, int k) {
        int start=0,end=nums.length-1;
        divide(start,end,nums,k);
        return ans;
    }
    public boolean divide(int start,int end,int nums[],int k){
        if(start<=end){
            int val= quickSort(start,end,nums);
            if(val==k){
                ans= nums[val];
                return true;
            }
              if(divide(start,val-1,nums,k)||divide(val+1,end,nums,k)){
                  return true;
              }
        }
        return false;
    }
    public int quickSort(int start,int end,int nums[]){
        int pivot=nums[end];
        int begin=start;
        int last=end;
        while(begin<=last){
           while(begin<=last && pivot>nums[begin]){
                begin++;
           }
           while (begin<=last && pivot<=nums[last]){
               last--;
           }
           if(begin<=last)swap(nums,begin,last);
        }
       swap(nums,begin,end);
        return begin;
    }
    public void swap(int nums[],int begin,int last){
        int temp =nums[begin];
        nums[begin]=nums[last];
        nums[last]=temp;
    }
}
