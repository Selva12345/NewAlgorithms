package com.learn;

public class FirstMissingPositive {
    public static void main(String[] args) {

    }
    public int firstMissingPositive(int[] nums) {
        int total=0,count=0;
        int cur=0;
        int n=nums.length;

        while(count<n){
            int temp=nums[cur];
            if(temp==cur){
                cur=count;
            }
            else if(temp<n){
                int pos=nums[temp];
                nums[temp]=temp;
                cur=pos;
            }else{
                cur=count;
            }
            count++;
        }
        for(int i=1;i<n;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return n;
    }
}
