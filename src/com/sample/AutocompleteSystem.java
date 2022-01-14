package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutocompleteSystem {
	class Pair{
		String s;
		int v;
		Pair(String s, int v){
			this.s=s;
			this.v=v;
		}
	}

	public static void main(String[] args) {
		String[] sentences= {"i love you", "island","ironman", "i love leetcode"};
		int[]time= {5,3,2,2};
		AutocompleteSystem a=new AutocompleteSystem(sentences,time);
		System.out.println(a.input('i'));
		System.out.println(a.input(' '));
		a.input('a');
		a.input('#');
	}
	String cs="";
	private List<String> input(char c) {
		List<String> res=new ArrayList<>();
		
			if(c=='#') {
				add(cs,1);
				cs="";
				return res;
			}
			cs+=c;
		Trie d= root.dict.get(c);
		if(d==null) {
			return res;
		}
		root=root.dict.get(c);
		PriorityQueue<Pair> pq=new PriorityQueue<>(
				(a,b)->a.v==b.v?a.s.compareTo(b.s):b.v-a.v);
		
		for( String s:d.values.keySet()) {
			pq.offer(new Pair(s,d.values.get(s)));
		}
		int r=pq.size();
		for(int i=0;i<Math.min(r, 3);i++) {
			res.add(pq.poll().s);
		}
		return res;
	}
	class Trie{
		Map<Character,Trie> dict;
		Map<String,Integer> values;
		Trie(){
			dict=new HashMap<>();
			values=new HashMap<>();
		}
	}
	Trie root;
	public AutocompleteSystem(String[] sentences, int[] time) {
		root=new Trie();
		for(int i=0;i<sentences.length;i++) {
			add(sentences[i],time[i]);
		}
	}
	private void add(String str, int time) {
		Trie cur=root;
		for(char c:str.toCharArray()) {
			Trie node=cur.dict.get(c);
			if(node==null) {
				node=new Trie();
				cur.dict.put(c, node);
			}
			cur=node;
			cur.values.put(str, cur.values.getOrDefault(str,0)+time);
		}
			
	}
}
