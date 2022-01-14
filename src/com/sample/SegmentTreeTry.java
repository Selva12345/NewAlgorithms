package com.sample;

public class SegmentTreeTry {
	static int tree[];
	public static void main(String[] args) {
		SegmentTreeTry s=new SegmentTreeTry();
		int arr[]= {3,4,5,6,8,2,9,1};
		int n=arr.length;
		int v=(int) Math.ceil(Math.log(n)/Math.log(2));
		int f=2*(int) Math.pow(2, v)-1;
		tree=new int[f];
		s.construct(0,arr,0,n-1);
		System.out.println(s.query(0,0,n-1,2,6));
		System.out.println(s.query(0,0,n-1,0,2));
		System.out.println(s.query(0,0,n-1,1,6));
		s.update(0,0,n-1,3,10);
		System.out.println(s.query(0,0,n-1,0,2));
	}

	private int update(int pos,int low, int high,int index, int value) {
			if(low==high) {
				if(low==index) {
					tree[pos]=value;
				}
				return tree[pos]; 
			}
			int mid=low+(high-low)/2;
			int r=update(2*pos+1,low,mid,index,value)+
			update(2*pos+2,mid+1,high,index,value);
			tree[pos]=r;
			return r;
	}

	private int query(int pos,int low, int high,int i, int j) {
		if(low>=i&&low<=j&&high>=i&&high<=j) {
			return tree[pos];
		}
		if(high<i||low>j) {
			return 0;
		}
		int mid=low+(high-low)/2;
		int r= query(2*pos+1,low,mid,i,j)+
		query(2*pos+2,mid+1,high,i,j);
		
		return r;
	}

	private  int construct(int pos,int[] arr, int low, int high) {
		if(low==high) {
			tree[pos]=arr[low];
			return arr[low];
		}
		int mid=low+(high-low)/2;
		tree[pos]=construct(2*pos+1,arr, low, mid)+
		construct(2*pos+2,arr, mid+1, high);
		return tree[pos];
	}
	
}
