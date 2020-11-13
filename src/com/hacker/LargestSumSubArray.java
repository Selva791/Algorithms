package com.hacker;
//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
//Easy one
public class LargestSumSubArray {
public static void main(String[] args){ 
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
    int n = a.length;    
    int max_sum = maxSubArraySum(a, n); 
    System.out.println("Maximum contiguous sum is " 
                       + max_sum); 
    }

private static int maxSubArraySum(int[] a, int n) {
	// TODO Auto-generated method stub
	int max=0;
	int update=0;
	for (int i = 0; i < a.length; i++) {
		max=max+a[i];

		if(max<0)
			max=0;
		
	if(update<max) {
		update=max;
	}
	}
	return update;
} 
}
