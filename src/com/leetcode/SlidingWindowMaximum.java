package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int nums[]= {9,10,9,-7,-4,-8,2,-6};
				
		int k=5;
		SlidingWindowMaximum s=new SlidingWindowMaximum();
		s.maxSlidingWindow(nums, k);
	}
	public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<Integer>();
		PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int n=nums.length;
        int res[]=new int[n-(k-1)];
        int max=nums[0];
        int index=0;
      
        boolean flag=false;
        for(int i=0;i<n;i++){
            int v=i-(k);
        	if(dq.contains(v)) {
        		dq.poll();
        		
        	}
           if(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]) {
        	  
        	   while(!dq.isEmpty()) {
        		   if(nums[dq.peekLast()]>nums[i]) {
        			   
        			   dq.offerLast(i);
        			   break;
        		   }else {
        			   dq.pollLast();
        		   }
        	   }
        	   if(dq.isEmpty())dq.offer(i);
           }else {
        	   dq.offerLast(i);
           }
           if(i>=k-1)
            res[i-(k-1)]=nums[dq.peek()];
        }
        return res;
    }
}






