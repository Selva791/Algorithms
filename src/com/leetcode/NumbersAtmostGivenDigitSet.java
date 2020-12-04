package com.leetcode;

public class NumbersAtmostGivenDigitSet {
	public static void main(String[] args) {
		NumbersAtmostGivenDigitSet nt = new NumbersAtmostGivenDigitSet();
		String[] val = {"3","4","8"};
				
		int n = 4;
		System.out.println(nt.atMostNGivenDigitSet(val, n));

	}

	 public int atMostNGivenDigitSet(String[] digits, int n) {

			int len = digits.length;
			int total = 0;
			for (int i = 1; i <= Integer.toString(n).length(); i++) {
				total += digitCount(digits, digits.length, i, Integer.toString(n));
			}
			return total;
		}

		public int digitCount(String[] digits, int n, int k, String s) {
			if (s.equals("0")) {
				return 0;
			}
	      if(s.equals("")) {
	    	  return 1;
	      }
			if (s.length() > k) {
				return (int) Math.pow(n, k);
			}
			int count = 0;
	        
	           for (int i = 0; i < n; i++) {
	        	   char c=s.charAt(0);
	        	   if((c-'0')>Integer.parseInt(digits[i])) {
	        		  count+= digitCount(digits,n,k-1,s); 
	        	   }
	        	   else if((c-'0')==Integer.parseInt(digits[i])) {
	        		   count+= digitCount(digits,n,k-1,s.substring(1)); 
	        	   }
	        	   
	        }
			
	           	
			return count;
		}
}
