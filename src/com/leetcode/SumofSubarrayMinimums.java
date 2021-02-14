package com.leetcode;

import java.util.Stack;

public class SumofSubarrayMinimums {
	public static void main(String[] args) {
		SumofSubarrayMinimums s=new SumofSubarrayMinimums();
		int arr[]= {3,1,2,4};
		System.out.println(s.sumSubarrayMins(arr));
	}

	public int sumSubarrayMins(int[] arr) {
		
		Stack<int[]> st1=new Stack<>(), st2=new Stack<>();
		int right []=new int[arr.length], left[]=new int[arr.length];
		int n=arr.length;
		for(int i=0;i<n;i++) {
			int count=1;
			while(!st1.isEmpty()&&st1.peek()[0]>arr[i]) {
				count+=st1.pop()[1];
			}
			st1.push(new int[] {arr[i],count});
			left[i]=count;
		}
		
		for(int i=n-1;i>=0;i--) {
			int count=1;
			while(!st2.isEmpty()&&st2.peek()[0]>arr[i]) {
				count+=st2.pop()[1];
			}
			st2.push(new int[] {arr[i],count});
			right[i]=count;
		}
		int total=0;
		for(int i=0;i<n;i++)total+=(left[i]*right[i]*arr[i]);
		
		return total;
	}
}
