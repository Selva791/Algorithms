package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
	public static void main(String[] args) {
		OpenTheLock o=new OpenTheLock();
		String[] deadends= {"0201","0101","0102","1212","2002"}; String target = "0202";
		o.openLock(deadends, target);
	}

	class Lock {
		String s;
		int c;

		Lock(String s, int c) {
			this.s = s;
			this.c = c;
		}
	}

	public int openLock(String[] deadends, String target) {
		Set<String> st = new HashSet<>();
		Set<String> visited = new HashSet<>();
		for (String str : deadends) {
			st.add(str);
		}
		Queue<Lock> q = new LinkedList<>();

		q.add(new Lock("0000", 0));
		visited.add("0000");
		while (!q.isEmpty()) {
			Lock lk = q.poll();
			String val = lk.s;

			if (st.contains(val)) {
				continue;
			}
			if (val.equals(target)) {
				return lk.c;
			}

			for (int i = 0; i < val.length(); i++) {
				char c = val.charAt(i);
				String s1 = "", s2 = "";
				if (c == '9') {
					s1 = val.substring(0, i) + "8" + val.substring(i + 1);
					s2 = val.substring(0, i) + "0" + val.substring(i + 1);
				} else if (c == '0') {
					s1 = val.substring(0, i) + "1" + val.substring(i + 1);
					s2 = val.substring(0, i) + "9" + val.substring(i + 1);
				} else {
					char t1 = c, t2 = c;
					char c1 = ++t1, c2 = --t2;
					s1 = val.substring(0, i) + c1 + "" + val.substring(i + 1);
					s2 = val.substring(0, i) + c2 + "" + val.substring(i + 1);
				}
				if (!visited.contains(s1)) {
					visited.add(s1);
					q.offer(new Lock(s1, lk.c + 1));
				}
				if (!visited.contains(s2)) {
					visited.add(s2);
					q.offer(new Lock(s2, lk.c + 1));
				}

			}

		}
		return -1;
	}
}
