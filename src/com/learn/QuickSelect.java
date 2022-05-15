package com.learn;

public class QuickSelect {

    public static void main(String[] args) {
        QuickSelect quickSelect=new QuickSelect();
        //123456
        System.out.println(quickSelect.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6},20));
    }
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int low=0, high=n-1;
        int indices[]=new int[n];
        for(int i=0;i<n;i++){
            indices[i]=i;
        }
       return divide(nums,indices,low,high,n-k);
    }
    public int divide(int[] nums,int indices[],int low,int high,int k){
        if(low<=high){
            int mid=quickSelect(nums,indices,low,high);
            if(mid==k)return nums[mid];
            int r=-1;
            r=divide(nums,indices,low,mid-1,k);
            if(r>-1)return r;
            r=divide(nums,indices,mid+1,high,k);
            if(r>-1)return r;
        }
        return -1;
    }
    public int quickSelect(int[] nums,int indices[],int low,int high){
        int pos= high;
        int pivot=nums[pos];
        int start=low;
        int end=high;
        high=high-1;
        while(low<high){
            while(low<end && pivot>=nums[low]){
                low++;
            }
            while(high>start&&pivot<=nums[high]){
                high--;
            }
            if(low<high){
                swap(nums,indices,low,high);
                low++;
                high--;
            }

        }
        if(low<end && nums[low]>pivot){
            swap(nums,indices,pos,low);
        }else{
            return pos;
        }

        return low;
    }
    public void swap(int[] nums,int indices[],int low,int high){
        int temp=nums[low];
        nums[low]=nums[high];
        nums[high]=temp;
        int t=indices[low];
        indices[low]=indices[high];
        indices[high]=t;
    }
}
