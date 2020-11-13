package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	public static void main(String[] args) {
		LFUCache l = new LFUCache(2);
		l.put(2, 1);
		l.put(1, 1);
		l.put(2, 3);
		l.put(4, 1);
		l.get(1);
		
		l.get(2);
	}

	Map<Integer, Integer> freq;
	Map<Integer, Integer> mp;
	Map<Integer, LinkedHashSet<Integer>> check;
	int count = 0;
	int cap = 0;
	int min = 0;

	public LFUCache(int capacity) {
		min = 0;
		count = 0;
		cap = capacity;
		mp = new HashMap<>();
		freq = new HashMap<>();
		check = new HashMap<>();
		check.put(1, new LinkedHashSet<>());
	}

	public int get(int key) {
     if(!mp.containsKey(key))return -1;
     
     int count=freq.get(key);
     	freq.remove(key);
     	freq.put(key, count+1);
     	check.get(count).remove(key);
        if(count==1&&check.get(count).size()==0) {
        	min++;
        }
        
        if(!check.containsKey(count+1)) {
        	check.put(count+1,new LinkedHashSet<>());
        }
        check.get(count+1).add(key);
        
        return mp.get(key);
   }

	public void put(int key, int value) {
		if(cap==0)return;

		if (mp.containsKey(key)) {
			mp.put(key, value);
			get(key);
			return;
		} else if (mp.size() == cap) {
				int v=check.get(min).iterator().next();
				check.get(min).remove(v);
				mp.remove(v);
				freq.remove(v);
				
		}
		mp.put(key, value);
		freq.put(key, 1);
		min=1;
		check.get(1).add(key);

	}
}
