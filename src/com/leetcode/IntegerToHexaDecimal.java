package com.leetcode;

public class IntegerToHexaDecimal {
	public static void main(String[] args) {
		IntegerToHexaDecimal hex=new IntegerToHexaDecimal();
		System.out.println(hex.toHex(268));
			
	}
	 private char[] hexDigits = new char[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	    
	    public String toHex(int num) {
	        if (num == 0) return "0";
	        StringBuilder sb = new StringBuilder();
	        while (num != 0) {
	        	int n=num & 15;
	            char digit = hexDigits[n];
	            sb.append(digit);
	            num >>>= 4;
	        }
	        return sb.reverse().toString();
	    }
}
