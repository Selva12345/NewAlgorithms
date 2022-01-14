package com.sample;

import java.util.Arrays;

public class ReorderDatainLogFiles {
	public static void main(String[] args) {
		String a[] = { "dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero" };
		ReorderDatainLogFiles r = new ReorderDatainLogFiles();
		r.reorderLogFiles(a);
	}

	  public String[] reorderLogFiles(String[] logs) {

			Arrays.sort(logs, (a, b) -> {
	            int c=a.indexOf(' ');
	            int d=b.indexOf(' ');
	            
	            if(a.charAt(c+1)<='9'){
	                if(b.charAt(d+1)<='9'){
	                    return 0;
	                }
	                return 1;
	            }
	            if(b.indexOf(d+1)<='9'){
	                return -1;
	            }
	            if(!a.substring(c).equals(b.substring(d))){
	                return a.substring(c).compareTo(b.substring(d));
	            }else{
	               return a.compareTo(b);
	            }
	            
			});
			return logs;
		}
	}
