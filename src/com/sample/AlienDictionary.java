package com.sample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.sample.AutocompleteSystem.Pair;

public class AlienDictionary {
		public static void main(String[] args) {
			AlienDictionary a=new AlienDictionary();
			System.out.println(a.alienOrder(new String[] {"wrt", "wrf", "er", "ett", "rftt"}));
		}
		public String alienOrder(String[] words) {
	        Map<Character, Set<Character>> map = new HashMap<>();
	        int[] indegree = new int[26];
	        // record the use of adjacent characters buildGraph (Map) and all characters (indegree)
	        buildGraph(indegree, map, words);
	        // continue into out of character for the coexistence of 1 to final results
	        return bfs(indegree, map);
	        
	    }
	    
	    public void buildGraph(int[] indegree, Map<Character, Set<Character>> map, String[] words) {
	    	// words exist
	 
	        for(String word : words) {
	            for(char ch : word.toCharArray()) {
	                map.putIfAbsent(ch, new HashSet<Character>());
	            }
	        }
	        
	        // find the character sequence
	        for(int i = 1; i < words.length; i++) {
	            String first = words[i-1];
	            String second = words[i];
	            int len = Math.min(first.length(), second.length());
	            for(int j = 0; j < len; j++) {
	            	// find the first different character
	                if(first.charAt(j) != second.charAt(j)) {
	                	// out of
	                    char out = first.charAt(j);
	                    // Penetration
	                    char in = second.charAt(j);
	                    // stored and recorded only met penetration has not yet been recorded over the degree of character
	                    // First, because HashSet into the same value will be reported abnormal
	                    // Second, because of the need to record only once
	                    if(!map.get(out).contains(in)) {
	                        map.get(out).add(in);
	                        indegree[in - 'a']++; // use [in - 'a'] corresponding to index letter may be stored position
	                    }
	                    // one pair of words, once a character appears different order after the characters are meaningless
	                    // so a direct break
	                    break;
	                }
	            }
	        }
	    }
	    
	    public String bfs(int[] indegree, Map<Character, Set<Character>> map) {
	        StringBuilder sb = new StringBuilder();
	        Queue<Character> q = new LinkedList<>();
	        // only need to exist already in the character of keySet you do not need to traverse all 26 letters
	        // If the degree is 0, stored in queue
	        for(char ch : map.keySet()) {
	            if(indegree[ch - 'a'] == 0) {
	                q.offer(ch);
	            }
	        }
	        
	        
	        while(!q.isEmpty()) {
	        	// The penetration into the character 0 result in sb
	            char out = q.poll();
	            sb.append(out);
	            
	            // topology (Queue) has been removed (poll) a node, which node adjacent to the degree of -1
	            for(char in : map.get(out)) {
	                indegree[in - 'a']--;
	                // looking into the degree of letters stored in queue 0
	                if(indegree[in - 'a'] == 0) {
	                    q.offer(in);
	                }
	            }
	        }
	        // check the length of sb, if the number of letters and words in the same order described is Valid, or otherwise present in order extra letters, small letters or is
	        return sb.length() == map.size() ? sb.toString() : "";
	    }
}
