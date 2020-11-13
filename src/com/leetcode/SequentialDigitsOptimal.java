package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigitsOptimal {

	public static void main(String[] args) {
		SequentialDigitsOptimal s=new SequentialDigitsOptimal();
		System.out.println(s.sequentialDigits(100,3000));
	}
	public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList();
        String s = "123456789";
        for(int l = 2; l <= s.length(); l++) {
            for(int j = 0; j <= s.length() - l; j++) {
                int num = Integer.parseInt(s.substring(j, j + l));
                if(num > high) return result;
                if(num >= low) result.add(num);
            }
        }
        
        return result;
    }
}
