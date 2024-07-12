package com.learn;

public class PathSumIV {
    public static void main(String[] args) {
        PathSumIV p=new PathSumIV();
        p.pathSum(new int[]{115,215,224,325,336,446,458});
    }
        class TreeNode{
            TreeNode left,right;
            int val;
            TreeNode(int val){
                this.val=val;
                left=right=null;
            }
        }
        public int pathSum(int[] nums) {
            TreeNode node =null;
            int total=0;
            for(int i=0;i<nums.length;i++){
                String cur=nums[i]+"";

                int d=cur.charAt(0)-'0';
                int p=cur.charAt(1)-'0';
                node=traverse(node,d,p,cur.charAt(2)-'0',1);

            }
            total=calculateTotal(node);
            return total;
        }
        public int calculateTotal(TreeNode node){
            if(node==null){
                return -1;
            }
            int left=calculateTotal(node.left);
            int right=calculateTotal(node.right);
            if(left==-1&&right==-1){
                return node.val;
            }
            if(left==-1){
                return right+node.val;
            }else if(right==-1){
                return left+node.val;
            }

            return left+right+node.val+node.val;
        }
        public TreeNode traverse(TreeNode node,int d,int p,int val,int m){
            if(node==null&&d==1&&p==1){
                node=new TreeNode(val);
                return node;
            }

            if(node==null){
                return node;
            }

            TreeNode left=traverse(node.left,d-1,p,val,m);
            TreeNode right=traverse(node.right,d-1,p-m,val,m*2);
            node.left=left;
            node.right=right;
            return node;
        }

}
