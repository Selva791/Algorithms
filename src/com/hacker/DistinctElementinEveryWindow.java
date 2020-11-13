package com.hacker;

import java.util.HashMap;
//NOT a Difficult one
public class DistinctElementinEveryWindow {
	public static void main(String[] args) {
		 int arr[] = {1, 2, 1, 3, 4, 2, 3},  k = 4; 
	     
	     countDistinct(arr, arr.length, k); 
	}
	static int finalCount = 0;

	private static void countDistinct(int[] arr, int length, int k) {
		System.out.println("Final Distinct Count : ");
		HashMap<Integer, Integer> map=new HashMap<>();
		for (int i = 0; i <k; i++) {
			if(map.get(arr[i])==null) {
				map.put(arr[i], 1);
				finalCount++;
			}else {
				int cn=map.get(arr[i]);
				map.put(arr[i],++cn);
				
			}
		}
		System.out.println(map);

		System.out.println(finalCount);
		for (int i = k; i < arr.length; i++) {
			
			if(map.get(arr[i-k])==1) {
				map.remove(arr[i-k]);
				finalCount--;

			}else if(map.get(arr[i-k])>1){
				int cout=map.get(arr[k-i]);
				map.put(arr[i-k], --cout);
				
			}
			if(map.get(arr[i])==null) {
				map.put(arr[i], 1);
				finalCount++;
			}else {
				int cn=map.get(arr[i]);
				map.put(arr[i],++cn);
				
			}
			System.out.println(map);
			System.out.println(finalCount);
		}
		return ;
	}
	
}
