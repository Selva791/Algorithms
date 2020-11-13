package com.hacker;
//https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
public class MaximumSumOfTwo {
public static void main(String[] args) {
	MaximumSumOfTwo sum =new MaximumSumOfTwo();
	int arr[] = new int[]{5, 5, 10, 100, 10, 5}; 
    System.out.println(sum.FindMaxSum(arr, arr.length)); 
}

private int FindMaxSum(int[] arr, int length) {
	int inc=arr[0];
	int exc=0;
	int another=0;
	for (int i = 1; i < arr.length; i++) {
		another=Math.max(exc, inc);
		inc=exc+arr[i];

		exc=another;
		
	}
	return Math.max(exc,inc);
}
}
