package com.revision;

public class CountOccurences {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 3, 3, 3, 3, 3 };

		// Element to be counted in arr[]
		int x = 3;
		int n = arr.length;
		int c = count(arr, x, n);
		System.out.println(x + " occurs " + c + " times");

	}

	private static int count(int[] arr, int x, int n) {
		// TODO Auto-generated method stub
		int first = start(arr, x, 0, n - 1);
		int last = end(arr, x, first, n - 1);
		return last - first + 1;
	}

	private static int end(int[] arr, int x, int low, int high) {
		// TODO Auto-generated method stub
		if (high >= low) {
			int mid = (low + high) / 2;
			if ((mid == arr.length-1 || arr[mid + 1] > x) && arr[mid] == x) {
				return mid;
			}
			if (arr[mid] > x) {
				return end(arr, x, low, mid - 1);
			} else {
				return end(arr, x, mid + 1, high);

			}
		}
		return -1;
	}

	private static int start(int[] arr, int x, int low, int high) {
		// TODO Auto-generated method stub
		if (low <= high) {
			int mid = (low + high) / 2;

			if ((mid == 0 || arr[mid - 1] < x) && arr[mid] == x) {
				return mid;
			}
			if (arr[mid] < x) {
				return start(arr, x, mid + 1, high);
			} else {
				return start(arr, x, low, mid - 1);

			}
		}
		return -1;

	}
}
