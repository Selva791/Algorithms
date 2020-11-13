package com.leetcode;

public class FirstMissingPositive {
	public static void main(String[] args) {
		FirstMissingPositive f=new FirstMissingPositive();
		int nums[]= {3,4,-1,1,9,7,0};
		System.out.println(f.firstMissingPositive(nums));
	}
	public int firstMissingPositive(int[] nums) {
        int positiveIndex = 0;
        // separate positive number and negative numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int temp = nums[i];
                nums[i] = nums[positiveIndex];
                nums[positiveIndex] = temp;
                positiveIndex++;
            }
        }
        // just negate num[i] if not already negative 
        for (int i = 0; i < positiveIndex; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[i] != 0 && index < nums.length && nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        // find the first index which is not negative, the answer
        for (int i = 0; i < positiveIndex; i++) {
            if (nums[i] >= 0) {
                return i+1;
            }
        }
        // all positive index is negativem, return length of positive array
        return positiveIndex+1;
    }
}
