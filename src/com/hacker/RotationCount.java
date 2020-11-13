package com.hacker;

public class RotationCount {
	public static void main(String[] args) {
		int arr[] = { 15, 18, 2, 3, 6, 12 };
		int n = arr.length;

		System.out.println(countRotations(arr, 0, n - 1));
	}

	private static int countRotations(int[] arr, int i, int n) {
		if(i>n) {
			return 0;
		}
		if(i==n) {
			return i;
		}
		
		int mid =i+( n-i )/ 2;
		if (mid>i && arr[mid] < arr[mid-1]) {
			return mid ;
		}
		if (mid<n && arr[mid] > arr[mid+1]) {
			return (mid+1);
		}
		if(arr[n]>arr[mid]) {
			countRotations(arr, i,mid-1);
		}
		
		return countRotations(arr, mid+1, n);
	}
}
