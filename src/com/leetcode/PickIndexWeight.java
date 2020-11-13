package com.leetcode;

import java.util.Random;

public class PickIndexWeight {
	public static void main(String[] args) {
		int []w= {1,2,3,4,5};
		PickIndexWeight pw=new PickIndexWeight(w);
		pw.pickIndex();
		
	}

	    private int[] cumSum;
	    private Random rand;

	    public PickIndexWeight(int[] w) {
	        rand = new Random();
	        cumSum = new int[w.length + 1];
	        cumSum[0] = 0;
	        for(int i = 0; i < w.length; i++) {
	            cumSum[i+1] = cumSum[i] + w[i];
	        }
	    }
	    
	    public int pickIndex() {
	    	//System.out.println(cumSum[cumSum.length - 1]);
	        int pos = rand.nextInt(cumSum[cumSum.length - 1]) + 1;
	        return binarySearch(pos) - 1;
	    }
	    
	    private int binarySearch(int pos) {
	        int left = 0, right = cumSum.length - 1;
	        while(left < right) {
	            int mid = left + (right - left) / 2;
	            if(cumSum[mid] < pos) {
	            	left = mid+1;
	            }
	            else {
	            	right = mid;
	            }
	        }
	        return left;
	    }
	}
