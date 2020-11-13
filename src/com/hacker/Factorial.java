package com.hacker;

import java.math.BigDecimal;

public class Factorial {
	static void extraLongFactorials(int n) {
		BigDecimal f = BigDecimal.valueOf(n);
		BigDecimal s = new BigDecimal("1");
		while (f .intValue()!= 0) {
			s = f.multiply(s);
			BigDecimal d = new BigDecimal("1");

			f = f.subtract(d);

		}
       System.out.println(s);
	}
	public static void main(String[] args) {
		extraLongFactorials(25);
	}

}
