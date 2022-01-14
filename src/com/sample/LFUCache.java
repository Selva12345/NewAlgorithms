package com.sample;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	public static void main(String[] args) {
		LFUCache l=new LFUCache(2);
		l.put(1, 1);
		l.put(2, 2);
		l.get(1);
		l.put(3, 3);
		l.get(2);
		l.get(3);
		l.put(4, 4);
		l.get(1);
		l.get(3);
		l.get(4);
	}
	  Map<Integer,Integer> mp;
	    Map<Integer,Integer> counter;
	    Map<Integer,LinkedHashSet<Integer>> order;
	    int size=0;
	    int min;
	    public LFUCache(int capacity) {
	        mp=new LinkedHashMap<>();
	        counter=new HashMap<>();
	        order=new HashMap<>();
	        size=capacity;
	        min=0;
	    }
	    
	    public int get(int key) {
	        if(mp.get(key)!=null){
	        	balance(key);
	            counter.put(key,counter.getOrDefault(key,0)+1);
	            int c=counter.get(key);
	            if(order.get(min)==null){
	                min++;
	            }
	             order.computeIfAbsent(c,v->new LinkedHashSet<Integer>()).add(key);
	            return mp.get(key);
	        }else{
	            return -1;
	        }
	    }
	    private void balance(int key){
	            System.out.println(counter);
	             int ct=counter.get(key);
	             order.get(ct).remove(key);
	            if(order.get(ct).isEmpty()){
	                order.remove(ct);
	            }
	    }
	    public void put(int key, int value) {
	        if(mp.size()>=size){
	            int k=order.get(min).iterator().next();
	            balance(k);
	            mp.remove(k);
	            counter.remove(k);
	        }
	        mp.put(key,value);
	        min=1;
	        counter.put(key,min);
	        order.computeIfAbsent(min,v->new LinkedHashSet<Integer>()).add(key);
	    }
}
