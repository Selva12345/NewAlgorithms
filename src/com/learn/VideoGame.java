package com.learn;

public class VideoGame {
    public static void main(String[] args) {
        int arr[]={1,0,0,1,0};
        System.out.println("Answer: "+ findScore(arr));
    }

    private static int findScore(int arr[]) {
        int len=arr.length;
        int p1=Integer.MIN_VALUE,p2=Integer.MIN_VALUE;
        int seg=len/2;
        for(int i=-1;i<=seg;i++){
            int temp=0;
            int pump=0;
            for(int j=0;j<=i;j++){
               if(arr[j]==1){
                   temp+=1;
               }else if(arr[j]==0){
                   temp-=1;
               }

            }
            p1=Math.max(p1,temp);
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]==1){
                    pump+=1;
                }else if(arr[j]==0){
                    pump-=1;
                }

            }
            p2=Math.max(p2,pump);
            if(p1>p2){
                return i+1;
            }
        }
        return -1;
    }
}
