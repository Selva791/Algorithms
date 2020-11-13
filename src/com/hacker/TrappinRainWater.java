package com.hacker;

public class TrappinRainWater {
	private static int findWater(int[] arr, int n) {
		int out = 0;
		int output=0;
		int left = 0;
		int right=0;
		for (int i = 0; i < n; i++) {
			if (arr[i] >= left) {
				left=arr[i];			
				right=i;
				output+=out;
				out=0;
			} else {
				//left -= arr[i];
				out += left-arr[i];
			}
			if(right<n&&i==n-1) {
				i=right;
				left=0;
				out=0;
			}
			
		}

		return output;
	}

	public static void main(String[] args) {
		int arr[] ={2, 0, 2}; 
			//{3, 0, 0, 2, 0, 4}; 
			//{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;

		System.out.println("Maximum water that " + "can be accumulated is " + findWater(arr, n));
	}

}
