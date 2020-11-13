package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII {
	public static void main(String[] args) {
		SingleNumberIII s = new SingleNumberIII();
		int nums[] = { 1, 2, 1, 3, 2, 5 };
		s.singleNumber(nums);
	}
//Reverse thinking
	public int[] singleNumber(int[] nums) {
		List<Integer> rt=new ArrayList<>();
		//rt.remov;
		int result[] = new int[2];
		int t=0;
			for(int n:nums) {
				
				t^=n;
			}
			int r=0;
			int m=t;
			for(int i=0;i<32;i++) {
			
				if((t&1)>0) {
					r=i;
					
				}
				
				t>>>=1;
				
			}
			//m>>=r;
			System.out.println(Integer.toBinaryString(r));
		//	t&=-t;
			t=r;
			System.out.println(Integer.toBinaryString(m>>2));
			for(int n:nums) {
				if((t&n)==0) {
					result[0]^=n;
				}else {
					result[1]^=n;
				}
			}
			return result;
	}
}
