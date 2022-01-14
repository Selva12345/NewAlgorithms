package com.sample;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int arr[] = { 9, 7, 8, 1, 2, 3, 5, 5, 3 ,1,0,};
		q.qsort(arr, 0, arr.length - 1);
		System.out.print(arr);
	}

	private void qsort(int[] arr, int low, int high) {
		if (low <high) {
			int p = partition(arr, low, high);
			qsort(arr, low, p - 1);
			qsort(arr, p+1, high);
		}

	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low;
		int j = high;

		while (i <= j) {
			while (i <= j && arr[i] <= pivot)
				i++;
			
			while (i <= j && arr[j] > pivot)
				j--;
			
			if (i <= j)
				swap(arr, i, j);
		}
		swap(arr, low, j);

		return j;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
