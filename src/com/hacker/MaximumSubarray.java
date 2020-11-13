package com.hacker;

public class MaximumSubarray {
public static void main(String[] args)  { 
    int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
    System.out.println("Maximum contiguous sum is " + 
                                   maxSubArraySum(a)); 
}

private static int maxSubArraySum(int[] a) {
int m=0;
int n=Integer.MIN_VALUE;
for (int i = 0; i < a.length; i++) {
	
	m=m+a[i];
	n=Math.max(m, n);
	m=Math.max(m, 0);
}
	return n;
} 
}
