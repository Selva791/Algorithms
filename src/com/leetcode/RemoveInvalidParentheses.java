package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
	public static void main(String[] args) {
		RemoveInvalidParentheses r = new RemoveInvalidParentheses();
		String s = "())(";
		System.out.println(r.removeInvalidParentheses(s));

	}

	Set<String> mp;

	public List<String> removeInvalidParentheses(String s) {

		mp = new HashSet<>();
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		int left = 0;
		int right = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else if (s.charAt(i) == ')') {
				if (left > 0) {
					left--;
				} else {
					right++;
				}
			}

		}
		int sum = right + left;
		helper(s, sb, n, sum, 0);

		return new ArrayList<>(mp);
	}

	public void helper(String s, StringBuilder sb, int n, int sum, int index) {
		if (sum < 0)
			return;

		if (index == s.length()) {
			if (sum == 0) {
				if (isValid(sb)) {
					mp.add(sb.toString());
				}
			}
			return;
		}

		char c = s.charAt(index);
		int len=sb.length();
		if (c == '(' || c == ')') {
			helper(s, sb, n, sum-1, index + 1);

			helper(s, sb.append(c), n, sum, index + 1);
		} else {
			helper(s, sb.append(c), n, sum, index + 1);
		}
			sb.setLength(len);
	}

	public boolean isValid(StringBuilder s) {
		int count = 0;
		 
		  
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}

		return count == 0;
	}
	/*
	 * public List<String> removeInvalidParentheses(String s) { List<String> ans =
	 * new ArrayList<>(); remove(s, ans, 0, 0, new char[]{'(', ')'}); return ans; }
	 * public void remove(String s, List<String> ans, int last_i, int last_j, char[]
	 * par) { for (int stack = 0, i = last_i; i < s.length(); ++i) { if (s.charAt(i)
	 * == par[0]) stack++; if (s.charAt(i) == par[1]) stack--; if (stack >= 0)
	 * continue; for (int j = last_j; j <= i; ++j) if (s.charAt(j) == par[1] && (j
	 * == last_j || s.charAt(j - 1) != par[1])) remove(s.substring(0, j) +
	 * s.substring(j + 1, s.length()), ans, i, j, par); return; } String reversed =
	 * new StringBuilder(s).reverse().toString(); if (par[0] == '(') // finished
	 * left to right remove(reversed, ans, 0, 0, new char[]{')', '('}); else //
	 * finished right to left ans.add(reversed); }
	 */
}
