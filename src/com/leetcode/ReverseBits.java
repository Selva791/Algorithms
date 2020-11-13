package com.leetcode;

public class ReverseBits {
	public static void main(String[] args) {
		ReverseBits r=new ReverseBits();
		System.out.println(r.reverseBits(2345));
	}

	public int reverseBits(int n) {
		int result=0;
		//System.out.println(Integer.toBinaryString(n));
		for(int i=0;i<32;i++) {
			result<<=1;
			if((n&1)>0) {
				result++;
			}
			n>>=1;
			
		}
		return result;
	}
}
