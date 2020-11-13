package com.hacker;

public class SingleNumberIIBItManipulation {
	public static void main(String[] args) {
		SingleNumberIIBItManipulation bit = new SingleNumberIIBItManipulation();
		int nums[] = { 2, 2, 3, 2 };
		bit.singleNumber(nums);
	}

	public int singleNumber(int[] nums) {
		int n = nums.length;
		int sum=0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < n; j++) {
				int s = nums[j] >> i&1;
				System.out.println(s);
				if (s == 1) {
					sum++;
					sum%=3;
					
					

				}
			}

		}
		return 0;

	}
}
