package com.leetcode;

public class BinarySearch {
	
	public static void main(String[] args) {
		int nums[]= {-1,0,3,5,9,12};
		int t=2;
		BinarySearch b=new BinarySearch();
		b.search(nums, t);
	}
	
	 public int search(int[] nums, int target) {
	        int n=nums.length;
	        int low=0;
	        int high=n;
	        
	        while(low<high){
	            int mid=low+((high-low)/2);
	            
	            if(nums[mid]>target){
	                high=mid;
	            }else if(nums[mid]<target){
	                low=mid+1;
	            }else if(nums[mid]==target){
	                return mid;
	            }
	        }
	        return -1;
	    }

}
