package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures {
	public static void main(String[] args) {
		DailyTemperatures d=new DailyTemperatures();
		int temp[]= {73, 74, 75, 71, 69, 72, 76, 73};
				//   0   1    2   3  4   5   6   7 
		//;
        Map<Character,Integer> mp=new HashMap<>();

		for (int i : d.dailyTemperatures(temp)) {
			System.out.print(i+" ");
		}
	}
	public int[] dailyTemperatures(int[] temperatures) {
	    Stack<Integer> stack = new Stack<>();
	    int[] ret = new int[temperatures.length];
	    for(int i = 0; i < temperatures.length; i++) {
	        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
	            int idx = stack.pop();
	            ret[idx] = i - idx;
	        }
	        stack.push(i);
	    }
	    return ret;
	}
}
