package com.leetcode;

public class CapacityToShipPackagesInNDays {
	public static void main(String[] args) {
		CapacityToShipPackagesInNDays c=new CapacityToShipPackagesInNDays();
		int []weights= {1,2,3,4,5,6,7,8,9,10};
		int D=5;
		int r=12890%10;
		System.out.println(r);
		c.shipWithinDays(weights, D);
		long a=123456789123456789L;
		
	}
	 public int shipWithinDays(int[] weights, int D) {
	        int left = 0, right = 0;
	        for (int w: weights) {
	            left = Math.max(left, w);
	            right += w;
	        }
	        while (left < right) {
	            int mid = (left + right) / 2, need = 1, cur = 0;
	            for (int w: weights) {
	                if (cur + w > mid) {
	                    need += 1;
	                    cur = 0;
	                }
	                cur += w;
	            }
	            if (need > D) left = mid + 1;
	            else right = mid;
	        }
	        return left;
	    }

}
