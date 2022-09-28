package com.learn;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf c=new CountOfSmallerNumbersAfterSelf();
        int nums[]={5,2,6,1};
        System.out.println(c.countSmaller(nums));

    }

    class Node {
        int val,start,end;
        int count = 0;
        Node left, right;

        Node(int val, Node left, Node right, int start, int end, int count) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> countOfSmallerElements = new ArrayList<>();
        int n = nums.length;
        int arr[] = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        Node head = segmentTree(min, max);
        int r = 0;
        for (int i = n-1; i >=0; i--) {
            updateNode(head, nums[i]);
          //  if(nums[n-1]==nums[i]-1)continue;
            r = getValue(head ,nums[n-1],nums[i]-1);
            countOfSmallerElements.add(0,r);
        }

        return countOfSmallerElements;
    }

    private int getValue(Node head, int start,int end) {
            if(head==null||start>end){
                return 0;
            }
            if(head.start==start&&head.end==end){
                return head.count;
            }
        int t=0;
        int mid= start+(end-start)/2;
        if (head.val>start&&head.val<end) {
           t+= getValue(head.left, start,mid);
           t+= getValue(head.right,mid+1,end);
        }else if(head.val>=end){
            t+=getValue(head.left, start,end);
        }else if(head.val<=start){
           t+= getValue(head.right, start,end);
        }
        return t;
    }

    private void updateNode(Node head, int val) {
        if (head == null) {
            return ;
        }
        if(head.start==val&&head.end==val){
             head.count++;
             return;
        }
         if(head.val>=val){
            updateNode(head.left,val);
        }else if(head.start<=val){
            updateNode(head.right,val);
        }
         head.count=head.left.count+ head.right.count;
         return;
    }

    private Node segmentTree(int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new Node(start, null, null, start, end, 0);
        }
        int mid = start + (end - start) / 2;
        Node left = segmentTree(start, mid);
        Node right = segmentTree(mid + 1, end);
        Node root = new Node(mid, left, right, start, end, 0);
        return root;

    }
}
