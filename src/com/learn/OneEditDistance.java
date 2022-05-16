package com.learn;

public class OneEditDistance {
    public static void main(String[] args) {
        OneEditDistance obj=new OneEditDistance();
        System.out.println(obj.isOneEditDistance("abcc","accc"));
    }
    public boolean isOneEditDistance(String s, String t) {
        if(s.length()==t.length()){
            if(s.length()==0&&t.length()==0)return false;
        }
        if(s.length()==1&&t.length()==0)return true;
        if(s.length()==0&&t.length()==1)return true;
        return checkDistance(s,t,0,0,new StringBuilder(),0);
    }
    private boolean checkDistance(String s, String t,int a,int b,StringBuilder sb,int flag){

        if(a==s.length()&&b==t.length()){
            if(t.equals(sb.toString())&&flag==1){
                return true;
            }
            return false;
        }
        if(flag==2){
            return false;
        }
        System.out.println(sb.toString());
        if(a<s.length()&&b<t.length()&&s.charAt(a)==t.charAt(b)){

            sb.append(s.charAt(a));
            if(checkDistance(s,t,a+1,b+1,sb,flag)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
        }else {
            if(checkDistance(s,t,a+1,b,sb,flag+1))return true;
            if(b<t.length()) {
                sb.append(t.charAt(b));
                if(checkDistance(s,t,a,b+1,sb,flag+1))return true;
                if(checkDistance(s,t,a+1,b+1,sb,flag+1))return true;
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
}
