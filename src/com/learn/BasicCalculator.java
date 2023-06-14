package com.learn;

import java.util.Stack;

class BasicCalculator {
    public static void main(String[] args) {
        BasicCalculator b=new BasicCalculator();
        System.out.println(b.calculate("1 + 1"));

    }
    public int calculate(String s) {
        int ans[]= calc(s,0);
        return ans[0];
    }
    public int[] calc(String s,int start){
        Stack<Integer> st=new Stack<>();
        int total=0;
        s=s+"+";
        char sign='+';
        int res[]=new int[2];
        for(int i=start;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' ')continue;
            if(c>='0'&&c<='9'){
                total=(total*10)+c-'0';
                continue;
            }

            if(c=='('){
                res= calc(s,i+1);
                i=res[1];
                total=res[0];
            }

            if(sign=='+'){
                st.push(total);
            }else if(sign=='-'){
                st.push(-total);
            }else if(sign=='*'){
                int prev=st.pop();
                st.push(prev*total);
            }else if(sign=='/'){
                int prev=st.pop();
                st.push(prev/total);
            }

            if(c==')'){
                res[1]=i;
                break;
            }
            sign=c;
            total=0;
        }
        int t=0;
        while(!st.isEmpty()){
            t+=st.pop();
        }
        res[0]=t;
        return res;

    }
}