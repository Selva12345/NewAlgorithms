package com.sample;

public class KthLargestElementinAnArray {
	public static void main(String[] args) {
		KthLargestElementinAnArray k=new KthLargestElementinAnArray();
		k.findKthLargest(new int[] {3,5,2,1,5,6,4,3,9}, 2);
	}

	public int findKthLargest(int[] nums, int k) {
	        int n=nums.length;
	        
	        System.out.println(quickSelect(nums,n-k,0,n-1));
	        return 0;
	    }

	private int quickSelect(int nums[], int k, int low, int high) {
		if (low < high) {
			int p = quickSort(nums, low, high);
			if (p == k) {
				return nums[p];
			}

			int a=quickSelect(nums, k, low, p - 1);
			a=quickSelect(nums, k, p + 1, high);
			return a;
		}
		return -1;
	}

	private int quickSort(int nums[], int low, int high) {
		int pivot = nums[low];
		int i = low + 1;
		int j = high;

		while (i <=j) {
			while (i <= j && nums[i] <= pivot) {
				i++;
			}

			while (i<=j && nums[j] >= pivot) {
				j--;
			}
			if(i<=j)
				swap(nums,i,j);
		}
		swap(nums,low,j);
		return j;

	}
	private void swap(int nums[],int i,int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}

}
