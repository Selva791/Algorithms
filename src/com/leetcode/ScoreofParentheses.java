package com.leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

public class ScoreofParentheses {
	public static void main(String[] args) {
		ScoreofParentheses s = new ScoreofParentheses();
		System.out.println(s.scoreOfParentheses("()()"));
	}

	public int scoreOfParentheses(String S) {
		int n = S.length(), i = 0;
		Stack<Integer> st = new Stack<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		int count = 0, start = 0;
		while (i < n) {
			if (S.charAt(i) == '(') {
				st.push(start++);
			} else {
				if (!st.isEmpty()) {
					int v = st.pop();
					int c = 0;
					if (!pq.isEmpty() && pq.peek()[0] < v||pq.isEmpty()) {
						c = 1;
					} else {
						while (!pq.isEmpty() && pq.peek()[0] > v) {

							c += pq.poll()[1];
						}
						c = 2 * c;
					}

					pq.offer(new int[] {v,c});

				}
			}

			i++;
		}
		int t=0;
		while(!pq.isEmpty()) {
			t+=pq.poll()[1];
		}
		return t;
	}

}
