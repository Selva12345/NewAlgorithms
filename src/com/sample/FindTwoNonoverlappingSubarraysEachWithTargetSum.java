package com.sample;

import java.util.HashMap;
import java.util.Map;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
	public static void main(String[] args) {
		FindTwoNonoverlappingSubarraysEachWithTargetSum f = new FindTwoNonoverlappingSubarraysEachWithTargetSum();
		System.out.println(f.minSumOfLengths(
				new int[] { 1,1,1,2,1,1,6,5,4}, 4));
	}

	/*public int minSumOfLengths(int[] arr, int target) {
	       int n = arr.length;
	       int best[] = new int[n];
	       Arrays.fill(best, Integer.MAX_VALUE);
	       int sum = 0, start = 0, ans = Integer.MAX_VALUE, bestSoFar = Integer.MAX_VALUE;
	       for(int i = 0; i < n; i++){
	           sum += arr[i];
	           while(sum > target){
	               sum -= arr[start];
	               start++;
	           }
	           if(sum == target){
	               if(start > 0 && best[start - 1] != Integer.MAX_VALUE){
	                   ans = Math.min(ans, best[start - 1] + i - start + 1);
	               }
	               bestSoFar = Math.min(bestSoFar, i - start + 1);
	           }
	           best[i] = bestSoFar;
	       }
	       return ans == Integer.MAX_VALUE ? -1 : ans;
	   }*/
	 public int minSumOfLengths(int[] arr, int target) {
         Map<Integer,Integer> mp1=new HashMap<>();
         mp1.put(0, -1);
         Map<Integer,Integer> mp2=new HashMap<>();
         mp2.put(0, -1);
       int n=arr.length;
       int a[]=new int[n];
       int b[]=new int[n];
       prefixSum(arr,target,mp1,a);
       int j=n-1,i=0;
       while(i<j){
           int temp=arr[i];
           arr[i]=arr[j];
           arr[j]=temp;
           i++;
           j--;
       }
       prefixSum(arr,target,mp2,b);
       int c[]=justDoIt(a,target,mp1);
       int d[]=justDoIt(b,target,mp2);
       int ans=Integer.MAX_VALUE;
       for(int k=1;k<n;k++) {
    	   ans=Math.min(d[i]+c[i-1],ans);
       }
       
       return ans;
   }
   public int[] prefixSum(int[] arr, int target, Map<Integer,Integer> mp,int sum[]){
      
       int n=arr.length;
       
       sum[0]=arr[0];
       mp.put(arr[0],0);
       for(int i=1;i<n;i++){
           sum[i]=sum[i-1]+arr[i];
           mp.put(sum[i],i);
       }
       return sum;
   }
   public int[] justDoIt(int arr[],int target,Map<Integer,Integer> mp){
           int c[]=new int[arr.length];
           int prev=Integer.MAX_VALUE;
           for(int i=0;i<arr.length;i++){
               int v=arr[i];
               if(mp.get(v-target)!=null){
                   int k=mp.get(v-target);
                   prev=Math.min(i-k,prev);
                   c[i]=prev;
               }else {
            	   c[i]=prev;
               }
           }
           return c;
   }
}
