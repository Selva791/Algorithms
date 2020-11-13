package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDolls {
	public static void main(String[] args) {
		RussianDolls r=new RussianDolls();
		
		int envelopes[][]= {{5,6},{6,4},{6,7},{2,3}};
		System.out.println(r.maxEnvelopes(envelopes));
		
	}
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 2) return envelopes.length;
        
        Arrays.sort(envelopes,(a,b)->a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int size = 0;
        
        for(int[] envelope: envelopes) {
            // binary search
            int left = 0, right = size, middle = 0;     // right = size
            while(left < right) {
                middle = left + (right - left) / 2;
                if(dp[middle] < envelope[1]) left = middle + 1;
                else right = middle;
            }
            
            // left is the right position to 'replace' in dp array
            dp[left] = envelope[1];
            if(left == size) size++;
        }
        return size;
    }
    
	}

