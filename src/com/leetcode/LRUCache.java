package com.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
	public static void main(String[] args) {
		LRUCache ca = new LRUCache(1);//["LRUCache","put","put","get","put","put","get"]
		//[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
		//[1],[2,1],[2],[3,2],[2],[3]
		ca.put(2, 1);
		System.out.println(ca.get(2));

		ca.put(3, 2);
		System.out.println(ca.get(2));

		//ca.put(1, 1);
		//ca.put(4, 1);
		System.out.println(ca.get(3));
	}

	Deque<Integer> dq = new LinkedList<Integer>();

	HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
	
	private int capacity;
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		int value=0;
		
		if(mp.containsKey(key)) {
			value=mp.get(key);
			dq.removeLastOccurrence(key);
			dq.push(key);
		
		}else {
			value=-1;
		}
		return value;

	}

	public void put(int key, int value) {
		
			if (!mp.containsKey(key)) {
				if (mp.size() < capacity) {
				mp.put(key, value);
				dq.push(key);
			}else {
				int removed=dq.removeLast();
				
				
				mp.remove(removed);
				dq.push(key);
				mp.put(key, value);
			}
		}else {
			
				mp.put(key, value);
				dq.removeLastOccurrence(key);
				dq.push(key);
				
			}
		
		
	}

}
