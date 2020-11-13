package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
	public static void main(String[] args) {
		// ["i", "love", "leetcode", "i", "love", "coding"], k = 2
		TopKFrequentWords t=new TopKFrequentWords();
		String s[]= {"i","love","leetcode","i","love","coding"};
		t.topKFrequent(s, 2);
	}
	
	 public List<String> topKFrequent(String[] words, int k) {
	        Map<String,Integer> mp=new HashMap<>();
	        for(String w:words){
	            if(mp.get(w)==null){
	                mp.put(w,1);
	                
	                
	            }else{
	                mp.put(w,mp.get(w)+1);
	            }
	            
	        }
	    	Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? 
	    			a.getKey().toLowerCase().compareTo(b.getKey().toLowerCase()) : b.getValue() - a.getValue());
	    		for (Map.Entry<String, Integer> entry : mp.entrySet()) {
	    	    	maxHeap.add(entry);

				}
	       
	        List<String> result=new ArrayList<>();
	        for(int i=0;i<k;i++){
	            result.add(maxHeap.poll().getKey());
	        }
	        
	        

	        return result;
	    }

}
