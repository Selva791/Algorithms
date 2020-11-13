package com.hacker;

import java.util.Arrays;

public class MinimumPlatform {
public static void main(String[] args) {
	 int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
	    int n = arr.length; 
	    System.out.println("Minimum Number of Platforms Required = "
	                        + findPlatform(arr, dep, n)); 

}

private static int findPlatform(int[] arr, int[] dep, int n) {
	Arrays.sort(arr);
	Arrays.sort(dep);
	int platform=1;
	int result=1;
	int i=0;
	int j=1;
	while(i<n&&j<n) {
		if(arr[j]<=dep[i]) {
			j++;
			platform++;
			
			if(result<platform) {
				result=platform;
			}
		}else {
			platform--;  //flight count will be reduced once it departured 
			
			i++;
		}
	}
		
	return result;	

}
}
