package com.sample;

public class MissingElementInSortedArray {
	public static void main(String[] args) {
		MissingElementInSortedArray m=new MissingElementInSortedArray();
		int arr[]= {1,2,3,4,5,6,7,8,10};
		System.out.println(m.missingElement(arr));
	}
	private int missingElement(int arr[]) {
		int low=0,high=arr.length-1;
		
		while(low<=high) {
			int mid=low+(high-low)/2;
			int d1=arr[mid]-arr[low];
			int d2=arr[high]-arr[mid];
			if(arr[mid]+1!=arr[mid+1])return arr[mid]+1;
			if(arr[mid]-1!=arr[mid-1])return arr[mid]-1;
			if(mid-low<d1) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		return arr[low]+1;
	}
}
