package com.Amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart {
	public static void main(String[] args) {
		RearrangeStringKDistanceApart rd = new RearrangeStringKDistanceApart();
		String str ="aaadbbcc";
				//"aaadbbccc";
		int k = 3;
		System.out.println(rd.rearrangeString(str, k));
	}

	public String rearrangeString(String str, int k) {
		int n = str.length();
		Map<Character, Integer> ch = new HashMap<Character, Integer>();
		for (Character s : str.toCharArray()) {
			int d = ch.getOrDefault(s, 0);
			ch.put(s, d + 1);

		}
		PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				if (ch.get(o1) != ch.get(o2))
					return ch.get(o2) - ch.get(o1);
				else
					return o1.compareTo(o2);

			}
		});

		for (Map.Entry<Character, Integer> entry : ch.entrySet()) {
			pq.offer(entry.getKey());

		}
		
		StringBuilder sd = new StringBuilder();
			while(!pq.isEmpty()) {
				List<Character> stock=new ArrayList<Character>();
				int f=Math.min(k, n);
				for(int i=0;i<f;i++) {
					if(pq.isEmpty()) {
						return "";
					}
					char d=pq.poll();
					int count=ch.get(d);
					if(count>0) {
						sd.append(d);
						count--;
						ch.put(d, count);
						if(count>0) {
							
							stock.add(d);
							//
						}
						
					}
					n--;
					
				}
				for(char c:stock) {
					pq.offer(c);
				}
			}
		return sd.toString();
	}
}
