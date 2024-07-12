package interview.com.tiktok;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // abdc
        //1+1+2+2=6/4
        //abdfcvg
        //bd=1+2=3/2
        //b=1/1=
        Map<Character,Character> mapper=new HashMap<>();
        Map<Character,Character> reverseVal=new HashMap<>();

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(mapper.containsKey(s.charAt(i))){
                sb.append(mapper.get(s.charAt(i)));
                continue;
            }else if(s.charAt(i)!=t.charAt(i)){
                if( reverseVal.get(t.charAt(i))!=null ){
                    return false;
                }else{
                    sb.append(t.charAt(i)+"");
                }

            }else if( !reverseVal.containsKey(t.charAt(i)) ){
                sb.append(t.charAt(i)+"");
            }
            if(!mapper.containsKey(s.charAt(i))) mapper.put(s.charAt(i),t.charAt(i));
            if(!reverseVal.containsKey(t.charAt(i))) reverseVal.put(t.charAt(i),s.charAt(i));
        }
        System.out.println(sb.toString());
        if(sb.toString().equals(t))return true;

        return false;

    }
}