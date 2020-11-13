package com.hacker;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class RearrangeString {
	public static void main(String[] args) {
		String str = "bbbaaaaacc";
		System.out.println(rearrangeString(str));
	}

	private static String rearrangeString(String str) {
		int alpha = 26;
		int n = str.length();
		int v[] = new int[alpha];

		for (int i = 0; i < n; i++) {
			int d = str.charAt(i) - 'a';
			v[d]++;

		}
		PriorityQueue<ideal> pq = new PriorityQueue<>(new QueueCompare());
		for (char i = 'a'; i < 'z'; i++) {
			int g = i - 'a';
			if (v[g] != 0) {
				pq.add(new ideal(v[g], i));
			}

		}
		System.out.println("");
		str = "";
		ideal prev =new ideal(-1,'#');
		while (pq.size() != 0) {
			ideal d = pq.poll();
			str = str + d.data;

			if (prev.key > 0) {
				pq.add(prev);

			}
			d.key--;
			prev=d;

		}
		System.out.println("OUTPUT: "+str);
		return (str.length()==n)?"Valid":"Invalid";
	}
}

class QueueCompare implements Comparator<ideal> {

	@Override
	public int compare(ideal o1, ideal o2) {
		if (o1.key > o2.key) {
			return -1;
		} else if (o1.key < o2.key) {
			return 1;
		} else {
			return 0;

		}

	}

}

class ideal {
	int key;
	char data;

	ideal(int key, char data) {
		this.key = key;
		this.data = data;
	}
}