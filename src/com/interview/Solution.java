package com.interview;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
            Solution solution = new Solution();
              System.out.println();
    }
    public static String getEncryptedName(String name){
        Validator validate=new Validator();

            boolean value= validate.validate(name);
            if(value){
                StringBuilder sb=new StringBuilder(name);
                StringBuilder newName=sb.reverse();
                String newNameUpdate=newName.toString().toLowerCase();
                return newNameUpdate;
            }else{
                throw new IllegalArgumentException("Try again with valid name");
            }


    }

}
