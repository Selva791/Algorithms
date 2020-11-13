package com.leetcode;

import java.util.PriorityQueue;

public class TripletIncreasingSubsequence {
	public static void main(String[] args) {
		TripletIncreasingSubsequence t=new TripletIncreasingSubsequence();
		int nums[]= {5,1,5,5,2,5,4};
			//{0,4,2,1,0,-1,-3}; 
			//{5,1,5,5,2,5,4};
				//{2,1,5,0,4,6};
			//{6,2,3,4,5};
		System.out.println(t.increasingTriplet(nums));
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->a.compareTo(b));
        pq.add("i");
        pq.add("love");
        pq.add("leetcode");
        pq.add("i");
        String s="";
        

	}

	 public boolean increasingTriplet(int[] nums) {

		 int n=nums.length;
		 if(n<3)return false;
		 int a=Integer.MAX_VALUE;
		 int b=Integer.MAX_VALUE;
		 for (int i = 0; i < nums.length; i++) {
			 	if(a>=nums[i]) {
			 		a=nums[i];
			 		
			 	}else if(b>=nums[i]){
			 		b=nums[i];
			 		
			 	}else {
			 		return true;
			 	}
			
		}
		 return false;
	 }
}
