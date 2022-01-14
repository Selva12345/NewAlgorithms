package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class CountofSmallerNumbersAfterSel {
	public static void main(String[] args) {
		CountofSmallerNumbersAfterSel c=new CountofSmallerNumbersAfterSel();
		c.countSmaller(new int[] {5,2,6,1,3});
		 Map<Integer,LinkedHashSet<Integer>> order= new HashMap<>();
		 order.get(0).iterator().remove();
	}

	int count[];

	public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		count = new int[n];
		List<Integer>  ans=new ArrayList<>();
		int indices[]=new int[n];
		for(int i=0;i<n;i++)indices[i]=i;
		mergerSort(nums, 0, n-1,indices);
		
		return ans;
	}

	public void mergerSort(int nums[],int low,int high,int indices[]){
				        
					        if(low<high){
					            int mid=low+(high-low)/2;
					            mergerSort(nums,low,mid,indices);
					            mergerSort(nums,mid+1,high,indices);
					            mergeAlgo(nums,low,mid,high,indices);
					        }
				        
				    }

	private void mergeAlgo(int nums[], int low, int mid, int high,int indices[]) {
		int arr[] = new int[high-low+1];
		int l = low;
		int r = mid+1;
		int i = 0;
		int rcount=0;
		while (l <=mid && r <=high) {
			if (nums[indices[l]] > nums[indices[r]]) {
				arr[i] = indices[r];
				r++;
				rcount++;
			} else {
				arr[i] = indices[l];
				count[indices[l]]+=rcount;
				l++;
			}
			i++;
		}

		while (l <=mid) {
			arr[i] = indices[l];
			count[indices[l]]+=rcount;
			l++;
			i++;
		}
		while (r <=high) {
			arr[i] = indices[r];
			r++;
			i++;
		}
		int j = 0;
		while (low <=high) {
			indices[low] = arr[j++];
			low++;
		}
	}
}
