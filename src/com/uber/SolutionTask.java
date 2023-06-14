package com.uber;

import java.util.ArrayList;
import java.util.List;

public class SolutionTask {
    String solution(String address, int[][] objects, String[] names) {
        double dist[]=new double[objects.length];
        int n=objects.length;

        int answer=0;
        for(int i=0;i<n;i++){
            int temp[]=objects[i];
            double d=0;
            if(temp.length==2){
                int val=(temp[0]*temp[0])+temp[1]*temp[1];
                d=Math.sqrt(val);
            }else{
                int x1=temp[0], y1=temp[1],x2=temp[2],y2=temp[3];
                int x=0,y=0;
                if(x1==x2){
                    x=x1;
                }
                else if((x1<0&&x2>0)||(x1>0&&x2<0)){
                    x=0;
                }else if(x1>0&&x2>0){
                    x=Math.min(x1,x2);
                }else if(x1<0&&x2<0){
                    x=Math.max(x1,x2);
                }
                if(y1==y2){
                    y=y1;
                }
                else if((y1<0&&y2>0)||(y1>0&&y2<0)){
                    y=0;
                }else if(y1>0&&y2>0){
                    y=Math.min(y1,y2);
                }else if(y1<0&&y2<0){
                    y=Math.max(y1,y2);
                }
                int val=(x*x)+(y*y);
                d=Math.sqrt(val);
            }
            dist[i]=d;
        }
        List<Integer> indices=new ArrayList<>();
        for(int i=0;i<n;i++){
            String s=names[i];
            boolean flag=true;
            int  m=0;
            for(int j=0;j<s.length();j++){
                char c=Character.toLowerCase(s.charAt(j));

                if(m<address.length()&&c==Character.toLowerCase(address.charAt(m))){
                    m++;
                }else if(m+1<address.length()&& Character.toLowerCase(address.charAt(m+1))==c&&flag){
                    flag=false;
                    m+=2;
                }else if(flag==true && m<address.length()&&c!=Character.toLowerCase(address.charAt(m))){
                    flag=false;
                    m++;
                }else{
                    flag=false;
                    break;
                }

                if(m==address.length()) {
                    flag = true;
                    indices.add(i);
                    break;
                }

            }
        }
        double min=Double.MAX_VALUE;
        int pos=0;
        for(int i:indices){
            if(min>dist[i]){
                pos=i;
                min=dist[i];
            }
        }
        return names[pos];
    }

    public static void main(String[] args) {
       String address= "Location";
        int [][]objects={{1,1},{3,3}};
        String[]names={"Locati","Location"};
        SolutionTask st=new SolutionTask();
        System.out.println(st.solution(address,objects,names));
    }
}
