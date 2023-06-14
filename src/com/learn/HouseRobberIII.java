package com.learn;
import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    public static void main(String[] args) {
        HouseRobberIII h=new HouseRobberIII();
        TreeNode node =new TreeNode(3);
        node.left=new TreeNode(2);
        node.left.right =new TreeNode(3);
        node.right=new TreeNode(3);
        node.right.right=new TreeNode(1);
        System.out.println(h.rob(node));
    }
    Map<Integer,int[]> dp;
    public int rob(TreeNode root) {
        dp=new HashMap<>();
        int ans= robberMove(root,0,0);
        return ans;
    }

    public int robberMove(TreeNode root, int start,int inc){

        if(dp.get(inc)!=null){
            int res[]=dp.get(inc);
            if(res[start]!=-1)return res[start];
        }
        if(root==null){
            return 0;
        }
        int count=0;
        if(start==0){
            count=robberMove(root.left,1,inc+1)+robberMove(root.right,1,inc+1)+root.val;
        }
        int value=robberMove(root.left,0,inc+1)+robberMove(root.right,0,inc+1);
        int r=Math.max(value,count);
        int res[]=dp.getOrDefault(inc,new int[]{-1,-1});
        res[start]=r;
        dp.put(inc,res);
        return r;
    }
}
