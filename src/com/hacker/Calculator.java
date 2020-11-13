package com.hacker;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
	public static void main(String[] args) {
		String s = "33-2*2+6/2";
		Calculator c = new Calculator();
		System.out.println(c.calculate(s));
	}

	public int calculate(String s) {
		Queue<Character> q = new LinkedList<>();
		for (char c : s.toCharArray()) {
			if (c != ' ') {
				q.offer(c);
			}
		}

		q.offer(' ');
		return helper(q);
	}

	private int helper(Queue<Character> q) {
		int prev = 0;
		char op = '+';
		int sum = 0;
		int num = 0;
		while (!q.isEmpty()) {
			char c = q.poll();
			if (c >= '0' && c <= '9') {
				num = num * 10 + c - '0';
			} else if (c == '(') {

			} else {
				switch (op) {
				case '+':
					sum+=prev;
					prev=num;
					break;

				case '-':
					sum+=prev;
					prev=-num;
					break;
				case '*':
					prev*=num;
					break;

				case '/':
					prev/=num;
					break;
				}
				
				num=0;
				
				op=c;
			}
			
		}
		return sum+prev;

	}
}
