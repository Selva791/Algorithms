package com.hacker;
//https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
public class CountOccurences {
	public static void main(String[] args) {
//sorted array so find starting and ending element
		int arr[] = { 1,2, 2, 3, 3, 3,3,3,3};

		// Element to be counted in arr[]
		int x = 3;
		int n = arr.length;
		int c = count(arr, x, n);
		System.out.println(x + " occurs " + c + " times");
	}

	private static int count(int[] arr, int x, int n) {
		int i;
		int mid = n - 1 / 2;
		i = first(arr, n - 1, x, 0);
		if (i == -1) {

		}

		int y = last(arr, i, x, n - 1,n);
		
		return Math.abs(i-y)+1;
	}

	private static int last(int[] arr, int i, int x, int n,int l) {
		// TODO Auto-generated method stub
		if (n >= i) {
			int mid = (i + n) / 2;               
			if ((mid == l-1 || arr[mid + 1] > x) && arr[mid] == x) {
				return mid;

			} else if (arr[mid + 1] > x) {
				return last(arr, i, x, mid - 1,l);
			} else {
				return last(arr, mid + 1, x, n,l);

			}
		}
		return -1;
	}

private static int first(int[] arr, int i, int x,int start) {
	if(start<=i) {
	int mid=(start+i)/2;
	if((mid==0||arr[mid-1]<x)&& x==arr[mid]) {
		return mid;
	}
	else if(arr[mid-1]<x) {
		return first(arr, i, x,mid+1);
	}else {
		return first(arr,  mid-1, x,start);

	}
	}
	return -1;
}
}
