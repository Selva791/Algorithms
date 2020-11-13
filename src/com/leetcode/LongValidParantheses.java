package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LongValidParantheses {
	public static void main(String[] args) {
		LongValidParantheses p = new LongValidParantheses();
		System.out.println(p.longestValidParentheses("(((((((()"));
	}

	public int longestValidParentheses(String s) {
 		if(s==null || s.length()==0||s.length()==1){
			return 0;
		}
		

		Stack<Integer> st = new Stack<>();
		int n = s.length();
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				if (!st.isEmpty() && s.charAt(st.peek()) == ')') {
					st.pop();

				} else {
					st.push(i);

				}

			} else {
				st.push(i);

			}

		}
		
		if(st.isEmpty()){
			return s.length();
		}
		int a = s.length();
		int b = 0;
		int maxLength = -1;
		int i=0;
		while(!st.isEmpty()&&i<st.size()){
			b = st.get(i);
			maxLength = Math.max(maxLength, a-b-1);
			a=b;
			i++;
		}
		maxLength = Math.max(maxLength, a);
		return maxLength;

	}

}
