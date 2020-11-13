package com.hacker;

//https://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/
public class ArrangingPairs {
	static int finalVal=0; 
	public static void main(String[] args) {

		int arr[] = { 0, 3, 5, 6, 4, 1, 7,2,8};

		// if (a, b) is pair than we have assigned elements
		// in array such that pairs[a] = b and pairs[b] = a
		int pairs[] = { 0, 3, 6, 1, 5, 4, 2 ,8,7};
		int m = pairs.length;

		// Number of pairs n is half of total elements
		int n = m / 2;
		pairing(arr, pairs, m);
		System.out.println("Minimum Swaps Requitred: "+finalVal);
	}

	private static void pairing(int[] arr, int[] pairs, int m) {

		for (int i = 0; i < pairs.length; i++) {
			int a = pairs[i];
			int b = pairs[a];
			for (int k = 0; k < arr.length; k++) {

				if (a == arr[k]) {
					if (b == arr[++k]) {

					} else {

						for (int j = k + 1; j < arr.length; j++) {
							if (arr[j] == b) {
								swap(k, j, arr);
								break;
							}
						}
					}
					break;
				}
				if (b == arr[k]) {

					if (a == arr[++k]) {

					} else {

						for (int j = k + 1; j < arr.length; j++) {
							if (arr[j] == a) {
								swap(k, j, arr);
								break;
							}
						}
					}
					break;
				}
			}
		}

	}

	private static void swap(int i, int j, int arr[]) {
		finalVal++;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
