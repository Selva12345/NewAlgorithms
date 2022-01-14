package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SecondMinimumTimetoReachDestination {
	public static void main(String[] args) {
		SecondMinimumTimetoReachDestination s = new SecondMinimumTimetoReachDestination();
		int[][] edges = { { 1, 2 },{ 1, 3 }, { 3, 4 }, { 4, 5 } };
		System.out.println(s.secondMinimum(5, edges, 3, 5));
	}

	  Map<Integer , List<Integer>> map; // adjacency map
	    
	    public int secondMinimum(int n, int[][] edges, int time, int change) {
	        map = new HashMap<>();
			
			// prepare adjacency map
	        for(int[] e : edges){
	            map.putIfAbsent(e[0] , new ArrayList<>());
	            map.putIfAbsent(e[1] , new ArrayList<>());
	            
	            map.get(e[0]).add(e[1]);
	            map.get(e[1]).add(e[0]);
	        }
		
		//create a min heap on int[] object [city , elapsedTime] , order by min elapsedTime first
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> {
	        return a[1] - b[1];
	    });
	    
		// initialize heap with city 1 and 0 time elapsed
	    pq.add(new int[]{1 , 0});
	    
		// use cache to record min time per city
	    Map<Integer , Integer> cache = new HashMap<>();
		
		// modification: we want to visit each city maximum two times with different times,
		// this will help in early termination when we visit the city again (3rd time or more)
	    HashSet<Integer> exhausted = new HashSet<>();
	    
	    while(!pq.isEmpty()){
	        
	        int[] top = pq.poll();
	        int city = top[0];
	        int timeElapsed = top[1];
	        
			// Base Termination : we have found our 2nd min time for city n
	        if(city == n && timeElapsed > cache.getOrDefault(city , Integer.MAX_VALUE)){
	            return timeElapsed;
	        }
	        
			
	        if(!cache.containsKey(city)){
				// we vistied this city for first time, so elapsed time is min for this city
	            cache.put(city , timeElapsed);
	        }else if(cache.get(city) == timeElapsed || exhausted.contains(city)){
				// early termination, if we are trying to visit the city 3rd time or more ,
				//or the elapsed time will not help in finding the solution
	            continue;
	        }else{
				// this means we are visiting the city with 2nd optimal time , we dont need to visit the city ever again
	            exhausted.add(city);
	        }
	        
			/**
				we visit the city on elapsedTime, we need to check if on basis of change time, whether this time falls in  cycle (green or red)
				if odd cycle (red), we must wait for this cycle to end
			**/
	        int factor = timeElapsed / change;
	        if(factor%2 == 1){
	            timeElapsed = (factor+1) * change;
	        }
	      
			//straight forward : visit the neighbours
	        for(int kid : map.getOrDefault(city , new ArrayList<>())){
	            
	            int visitTime = timeElapsed + time;
	            if(!exhausted.contains(kid)){
	                pq.add(new int[]{kid , visitTime});
	            }
	        }
	    }
	    
	    return -1;
	}
}
