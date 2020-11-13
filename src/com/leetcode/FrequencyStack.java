package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class FrequencyStack {
	Map<Integer, Integer> mp = new LinkedHashMap<Integer, Integer>();
	static Stack<Integer> q = new Stack<>();

	public FrequencyStack() {

	}

	public void push(int x) {
		if (mp.containsKey(x)) {
			mp.put(x, mp.get(x) + 1);

		} else {
			mp.put(x, 1);
		}
		q.push(x);
	}

	public int pop() {
		int high = 0;
		int key = 0;
		for (Entry<Integer, Integer> e : mp.entrySet()) {
			if (e.getValue() > high) {
				high = e.getValue();
				key = e.getKey();

			}
		}
		int size = q.size() - 1;
		while (size >= 0) {
			int keyValue = q.get(size);
			int value = mp.get(keyValue);
			if (value == high) {
				if (key == keyValue) {
					mp.put(key, mp.get(key) - 1);
					q.remove(size);
					return key;
				} else {
					mp.put(keyValue, mp.get(keyValue) - 1);
					q.remove(size);
					return keyValue;
				}

			}
			size--;

		}

		return 0;

	}

	public static void main(String[] args) {
		FrequencyStack fs = new FrequencyStack();
		fs.push(5);
		fs.push(7);
		fs.push(5);
		fs.push(7);
		fs.push(4);
		fs.push(5);
		// System.out.println(q.pop()+ " "+q);
		System.out.println(fs.pop() + " " + fs.pop() + " " + fs.pop() + " " + fs.pop());

	}
}
