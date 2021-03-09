package com.leetcode;

public class BrokenCalculator {
	public static void main(String[] args) {
		BrokenCalculator b = new BrokenCalculator();
		System.out.println(b.brokenCalc(3, 10));
	}


	public int brokenCalc(int X, int Y) {
		int res = 0;
		while (Y > X) {
			Y = Y % 2 > 0 ? Y + 1 : Y / 2;
			res++;
		}
		return res + X - Y;
	}

}
