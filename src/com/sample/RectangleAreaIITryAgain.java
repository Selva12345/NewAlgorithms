package com.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RectangleAreaIITryAgain {
	public static void main(String[] args) {
		int[][] mat = {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
		RectangleAreaIITryAgain r = new RectangleAreaIITryAgain();
		System.out.println(r.rectangleArea(mat));
	}
	public int rectangleArea(int[][] rectangles) {
		int n=rectangles.length,m=rectangles[0].length;
		int OPEN=1,CLOSE=-1;
		int event[][]=new int [2*n][m];
		Set<Integer> xvalues=new HashSet<>();
		int j=0;
		for(int i=0;i<n;i++) {
			int rec[]=rectangles[i];
			event[j++]=new int[] {rec[1],OPEN,rec[0],rec[2]};
			event[j++]=new int[] {rec[3],CLOSE,rec[0],rec[2]};
			xvalues.add(rec[0]);
			xvalues.add(rec[2]);
		}
		Arrays.sort(event,(a,b)->a[0]-b[0]);
		int[] x=new int[xvalues.size()];
		int k=0;
		for(int a:xvalues)x[k++]=a;
		Arrays.sort(x);
		Map<Integer,Integer> xi=new HashMap<>();
		for(int i=0;i<xvalues.size();i++) {
			xi.put(x[i], i);
		}
		Node node=new Node(0,x.length-1,x);
		int yt=event[0][0] ;
		long t=0;
		long sum=0;
		for(int st[]:event) {
			int y=st[0], val=st[1],x1=st[2],x2=st[3];
			 t+=((y-yt)*sum);
			 sum=node.update(xi.get(x1),xi.get(x2),val);
			 yt=y;
			 
		}
		return (int)t;
	}
	class Node{
		Node left,right;
		int start,end,count,total;
		int x[];
		Node(int start,int end,int x[]){
			this.start=start;
			this.end=end;
			left=null;
			right=null;
			this.x=x;
			total=0;
			count=0;
		}
		private int getMid() {
			return start+(end-start)/2;
		}
		private Node getLeft() {
			if(left==null) {
				left=new Node(start,getMid(),x);
			}
			return left;
		}
		private Node getRight() {
			if(right==null) {
				right=new Node(getMid(),end,x);
			}
			return right;
		}
		private long update(int i,int j,int val) {
			if(i>=j) {
				return 0;
			}
			
			if(start==i&&end==j) {
				count+=val;
			}else {
				getLeft().update(i, Math.min(getMid(), j), val);
				getRight().update(Math.max(getMid(),i), j, val);
				
			}
			
			if(count>0) {
				total=x[end]-x[start];
			}else {
				total=getLeft().total+getRight().total;
			}
			
			return total;
		}
	}
}




