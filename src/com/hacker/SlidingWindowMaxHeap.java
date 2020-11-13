package com.hacker;

//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
//My own and best fucking solution using MAX HEAP
public class SlidingWindowMaxHeap {
	static int size;
	static int a[];

	SlidingWindowMaxHeap(int k) {
		size = k + 1;
		a = new int[size];
	}

	private static void printMax(int[] arr, int length, int k) {
		// TODO Auto-generated method stub
		a[0] = Integer.MIN_VALUE;
		int kgf = 1;

		for (int j = 0; j < arr.length; j++) {

			a[kgf] = arr[j];
			if (kgf == k) {
				maxheap(a, k);
				j = j - (k - 1);
				kgf = 0;
			}
			kgf++;

		}

	}

	private static void maxheap(int[] a, int k) {
		// TODO Auto-generated method stub

		for (int i = size / 2; i >= 1; i--) {
			heapify(i);
		}
		System.out.println(a[1]);

	} 

	private static void heapify(int i) {
		if (!isLeaf(i)) {
			if (a[i] < a[right(i)] || a[i] < a[left(i)]) {
				if (a[left(i)] < a[right(i)]) {
					swap(i, right(i));
					heapify(right(i));
				} else {
					swap(i, left(i));
					heapify(left(i));

				}

			}

		}
	}

	private static void swap(int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	private static int left(int i) {
		// TODO Auto-generated method stub

		return 2 * i;
	}

	private static int right(int i) {
		// TODO Auto-generated method stub
		return (2 * i) + 1;
	}

	private static boolean isLeaf(int i) {
		// TODO Auto-generated method stub
		if (i >= size / 2 && i <= size) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		SlidingWindowMaxHeap sd = new SlidingWindowMaxHeap(3);
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;

		printMax(arr, arr.length, k);
	}

}
