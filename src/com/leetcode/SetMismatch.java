package com.leetcode;

public class SetMismatch {
	public static void main(String[] args) {
		SetMismatch s=new SetMismatch();
		System.out.println(s.findErrorNums(new int[] {1,2,5,4,2}));
	}
	 public int[] findErrorNums(int[] nums) {
	        int n = nums.length;
	        int[] count = new int[n];
	        int[] ans = {0,0};
	        for(int i = 0; i < n; i++) {
	            ans[1] ^= (i+1) ^ nums[i];
	            if (++count[nums[i]-1] == 2)
	                ans[0] = nums[i];
	        }
	        ans[1] ^= ans[0];
	        return ans;
	    }
}
