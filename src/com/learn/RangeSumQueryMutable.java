package com.learn;

public class RangeSumQueryMutable {
    public static void main(String[] args) {
        int nums[]={0,9,5,7,3};
        RangeSumQueryMutable r=new RangeSumQueryMutable(nums);
        r.sumRange(4,4);
        r.sumRange(2,4);
        r.sumRange(3,3);
        r.update(4,5);
        r.update(1,7);
        r.update(0,8);
        r.sumRange(1,2);
        r.update(1,9);
        r.sumRange(4,4);
        r.update(3,4);
    }
    Node res;
    int start,end;
    int nums[]=null;
    class Node{
        Node left,right;
        int val,start,end;
        Node(int val,int start,int end){
            this.val=val;
            this.start=start;
            this.end=end;
            left=null;
            right=null;
        }
    }
    public RangeSumQueryMutable(int[] nums) {
        int n=nums.length;
        this.nums=nums;
        res=create(0,n-1,nums);
        start=0;
        end=n-1;
    }
    public void update(int index, int val) {

        updateIndex(index,val,res,start,end);
    }

    public void updateIndex(int index, int values,Node res,int start,int end) {
        if(start>end){
            return;
        }
        if(start==index&&end==index){
            res.val=values;
            return;
        }
        int mid=start+(end-start)/2;

        if(mid>=index){
            updateIndex(index,values,res.left,start,mid);
        }
        if(mid<index){
            updateIndex(index,values,res.right,mid+1,end);
        }
        res.val=res.left.val+res.right.val;
        return;
    }

    public int sumRange(int left, int right) {
        return query(left,right,res);
    }
    public int query(int left, int right,Node res){

        if(res.start==left&&right==res.end){
            return res.val;
        }

        int mid=res.start+(res.end-res.start)/2;
        if(right<=mid){
            return query(left,right,res.left);
        }
        else if(left>=mid+1){
            return query(left,right,res.right);
        }else{
            return query(left,mid,res.left)+query(left,mid+1,res.right);
        }

    }

    public Node create(int start,int end,int []nums){

        if(start==end){
            Node r=new Node(nums[start],start,end);
            return r;
        }
        int mid=start+(end-start)/2;
        Node left=create(start,mid,nums);
        Node right=create(mid+1,end,nums);
        Node ans=new Node(left.val+right.val,start,end);
        ans.left=left;
        ans.right=right;
        return ans;
    }
}
