package com.revision;

public class BitWise {
	public static void main(String[] args) {
		int a = 18;
		int b = 15;
		//System.out.println(Integer.toBinaryString(a));
	//	System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(8));
		System.out.println(Integer.toBinaryString(9));
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toBinaryString(11));
		System.out.println(Integer.toBinaryString(12));

		System.out.println(Integer.toBinaryString(13));

		int c = a & b;
		int d = a | b;
		System.out.println("Bitwise and & " + c);
		System.out.println("Bitwise and OR | " + d);
		int t = a ^ b;
		int e = 10;
		//Best Swap Algo: Using XOR operator
		a = a ^ b ^ a & (b = a);
		System.out.println("Bitwise ^ Swap  a= " + a + " b= " + b);
		int bit=0;
		String s=Integer.toBinaryString(150);
		System.out.println(10>>2);
		bit=bit^(1<<(150));
		String s1=Integer.toBinaryString(bit);

		bit=bit^(1<<(150));

				

	}
}
