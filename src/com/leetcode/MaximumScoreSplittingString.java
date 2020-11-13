package com.leetcode;

public class MaximumScoreSplittingString {
	public static void main(String[] args) {
		String s = "011101";
		MaximumScoreSplittingString m = new MaximumScoreSplittingString();
		System.out.println(m.maxScore(s));
	}

	public int maxScore(String s) {
		int total = 0;
		for (int i = 1; i < s.length(); i++) {
			int zero = 0;
			int one = 0;
				int k=0;
				int j=0;
	
			for (j = 0; j < i; j++) {
				if (s.charAt(j) == '0') {
					zero++;

				}
			}
			for (k = j; k <s.length(); k++) {
				
			
				if (s.charAt(k) == '1') {
					one++;
				}
			}
		
			if (total < (zero + one)) {
				total = zero + one;
			}
		}
		return total;
	}
}
