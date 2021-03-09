package com.leetcode;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		DivideTwoIntegers d = new DivideTwoIntegers();
		
		
		System.out.println(d.divide(14, 4));
	}

	 public int divide(int A, int B) {
	        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
	        int a = Math.abs(A), b = Math.abs(B), res = 0;
	        System.out.println(Integer.toBinaryString(a));
	        for (int x = 31; x >= 0; x--) {
	        	System.out.println(a>>x);
	            if ((a >> x) - b >= 0) {
	                res += 1 << x;
	                a -= b << x;
	            }
	        }
	        return (A > 0) == (B > 0) ? res : -res;
	    }
	
}
