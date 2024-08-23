package com.salesforce;

import java.util.Stack;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.remove(12);
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5};
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int median = (n + m) / 2;
        if (n < m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0, end = m;
        int len = n + m;
        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int mid2 = (median) - mid1;
            int left_1 = mid1 == 0 ? Integer.MIN_VALUE : nums2[mid1 - 1];
            int right_1 = mid1 == m ? Integer.MAX_VALUE : nums2[mid1];
            int left_2 = mid2 == 0 ? Integer.MIN_VALUE : nums1[mid2 - 1];
            int right_2 = mid2 == n ? Integer.MAX_VALUE : nums1[mid2];
            System.out.println("mid1=" + mid1);
            System.out.println("mid2=" + mid2);

            if (left_1 <= right_2 && left_2 <= right_1) {
                if (len % 2 == 0) {
                    double a = Math.max(left_1, left_2);
                    double b = Math.min(right_1, right_2);
                    return (a + b) / 2.0;
                } else {
                    return Math.min(right_1, right_2);
                }
            }
            if (left_1 > right_2) {
                end = mid1 - 1;
            } else {
                start = mid1 + 1;
            }
        }
        return -1;
    }
}
