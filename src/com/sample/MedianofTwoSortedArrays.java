package com.sample;

public class MedianofTwoSortedArrays {
	public static void main(String[] args) {
		MedianofTwoSortedArrays m=new MedianofTwoSortedArrays();
		System.out.println(m.findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int n = nums1.length;
		int m = nums2.length;

		if (n > m) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int low = 0, high = n ;

		while (low <= high) {

			int cut1 = low + (high - low) / 2;

			int cut2 = ((n + m) / 2) - cut1;

			int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
			int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
			int r1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];
			int r2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];

			if (l1 > r2) {
				high = cut1 - 1;
			} else if (l2 > r1) {
				low = cut1 + 1;
			} else {
				if ((n + m) % 2 == 0) {
					int a = Math.max(l1, l2);
					int b = Math.min(r1, r2);
					return (double) ((a + b) / 2.00);
				} else {
					int r = Math.min(r1, r2);
					return (double) (r);
				}
			}

		}
		return -1;
	}
}
