package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxChunksToMakeSorted {
	public static void main(String[] args) {
		MaxChunksToMakeSorted m=new MaxChunksToMakeSorted();
		System.out.println(m.maxChunksToSorted(new int[] {1,5,3,0,2,6,7,4}));
	}

	 public int maxChunksToSorted(int[] arr) {
	        if (arr == null || arr.length == 0) return 0;
	        
	        int[] max = new int[arr.length];
	        max[0] = arr[0];
	        for (int i = 1; i < arr.length; i++) {
	            max[i] = Math.max(max[i - 1], arr[i]);
	        }
	        
	        int count = 0;
	        for (int i = 0; i < arr.length; i++) {
	            if (max[i] == i) {
	                count++;
	            }
	        }
	        
	        return count;
	    }
}
