package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class DinnerPlateStacks {
	public static void main(String[] args) {
		DinnerPlateStacks d=new DinnerPlateStacks(2);
		d.push(1);
		d.push(2);
		d.push(3);
		d.push(4);
		d.push(5);
		d.push(7);
		d.push(6);
		d.push(9);
		d.popAtStack(2);
		d.popAtStack(2);
		d.push(20);
		d.push(21);
		d.popAtStack(0);
		d.popAtStack(2);
		d.pop();
		d.pop();
		d.pop();
		d.pop();
		d.pop();
	}
	List<Stack<Integer>> values;
	int len = 0;
	int last = -1,real;
	TreeSet<Integer> tr;

	public DinnerPlateStacks(int capacity) {
	        values=new ArrayList<>();
	        len=capacity;
	        tr=new TreeSet<>();
	        Stack<Integer> st=new Stack<>();
	        values.add(st);
	        tr.add(0);
	    }

	public void push(int val) {

		last = tr.pollFirst();

		if (last < values.size() && values.get(last).size() < len) {
			values.get(last).push(val);
		} else if (last + 1 >= values.size()) {
			Stack<Integer> st = new Stack<>();
			st.push(val);
			values.add(st);
			last += 1;
		} else if (!tr.isEmpty()) {
			last = tr.pollFirst();
			values.get(last).push(val);
		}
		
		System.out.println(values);
		tr.add(last);
	}
int a=Integer.MAX_VALUE;
	public int pop() {
		 int i=values.size()-1;
	        if(i<0)return -1;
	        tr.add(i);
	        
	        Stack<Integer> p=values.get(i);
	        if(p.isEmpty()){
	            values.remove(i);
	            return -1;
	        }
	        int r=p.pop();
	        if(p.isEmpty()){
	            values.remove(i);
	         }
	        return r;
	}

	public int popAtStack(int index) {
		if (values.size() <= index)
			return -1;

		tr.add(index);
		Stack<Integer> p = values.get(index);
		// System.out.println(tr);
		if (p.isEmpty()) {
			
			return -1;
		}
		int r = p.pop();
		
		return r;
	}
}
