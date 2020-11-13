package com.hacker;

import java.util.Arrays;

public class TrainTime {
	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		            //910  1120 1130 1200  1900  2000

		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		finder(arr, dep);
	}

	private static void finder(int[] arr, int[] dep) {
		// TODO Auto-generated method stub
		Arrays.sort(dep);
		Arrays.sort(arr);
		int c=0;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]<dep[i]&&dep[i]<arr[i+1]) {
				
			}if(arr[i]<dep[i]&&dep[i]>arr[i+1]) {
				c++;
			}
		}
     System.out.println(c);
	}
}
