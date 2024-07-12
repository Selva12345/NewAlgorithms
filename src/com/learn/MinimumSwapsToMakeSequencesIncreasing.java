package com.learn;

public class MinimumSwapsToMakeSequencesIncreasing {
    public static void main(String[] args) {
        MinimumSwapsToMakeSequencesIncreasing m=new MinimumSwapsToMakeSequencesIncreasing();
       // [0,4,4,5,9]
        //[0,1,6,8,10]
        int nums1[]={0,4,4,5,9};
        int nums2[]={0,1,6,8,10};
        System.out.println(m.minSwap(nums1,nums2));

    }
        public int minSwap(int[] nums1, int[] nums2) {
            int prev1=nums1[0];
            int prev2=nums2[0];
            int max=Integer.MAX_VALUE;
            int result=0;
            for(int i=1;i<nums1.length;i++){
                if(prev1>=nums1[i]||prev2>=nums2[i]){
                    int t1=nums1[i];
                    int t2=nums2[i];
                    int k=i;
                    System.out.println(prev1+" "+prev2);
                    max=Integer.MAX_VALUE;
                    for(int j=i;j>=0;j--){
                        int val= traverse(prev1,prev2,nums1,nums2,i,j);
                        if(val!=Integer.MAX_VALUE){
                            max=Math.min(max,val);
                            break;
                        }
                    }
                    if(i-2>=0){
                        int val= traverse(nums1[i-2],nums2[i-2],nums1,nums2,i,i-1);
                        if(val!=Integer.MAX_VALUE){
                            max=Math.min(max,val);
                            break;
                        }
                    }


                    result+=max;


                }
                prev1=nums1[i];
                prev2=nums2[i];
            }
            return result;

        }
        public int traverse(int prev1,int prev2,int[] nums1, int[] nums2,int n,int start){
            if(start>n){
                return 0;
            }

            int t1=nums1[start];
            int t2=nums2[start];
            System.out.println(t1+" "+t2);
            int count=Integer.MAX_VALUE;
            if(t1>prev1&&t2>prev2){
                int temp=traverse(t1,t2,nums1,nums2,n,start+1);
                count=temp;
                count=Math.min(count,temp);
            }
            if(t2>prev1&&t1>prev2){
                nums1[start]=t2;
                nums2[start]=t1;
                int temp=traverse(t2,t1,nums1,nums2,n,start+1);
                if(temp!=-1){
                    temp+=1;
                    count=Math.min(count,temp);
                }

            }

            return count;
        }

}
