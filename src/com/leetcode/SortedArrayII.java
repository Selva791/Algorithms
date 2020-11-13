package com.leetcode;

public class SortedArrayII {
	public static void main(String[] args) {
		SortedArrayII s=new SortedArrayII();
		int nums[]= {3,1,1,1};
		int target=3;
		s.search(nums, target);
	}
	 public boolean search(int[] nums, int target) {
	        int n=nums.length;
	        if(n==1&&nums[0]==target)return true;
	        
	        int start=0;
	        int end=n-1;
	        
	        while(start<end){
	            int mid=start+(end-start)/2;
	            
	            if(nums[mid]>nums[end]){
	                start=mid+1;
	            }else if(nums[start]>nums[end]){
	            	if(nums[mid]==nums[end])
	                end=mid;
	            	
	            }else if(nums[start]==nums[end]){
	            	if(nums[mid]==nums[end])
	            	start++;
	            }else { if(nums[mid]<nums[end]){
	            }
	                end=mid;
	            }
	            
	            
	        }
	        
	     System.out.println(start);
	        int realmid=start;
	         start=0;
	         end=n;
	    
	        while(start<end){
	            int mid=start+(end-start)/2;
	            int real=(realmid+mid)%n;
	            if(nums[real]<target){
	                start=mid+1;
	            }else if(nums[real]>target){
	                end=mid;
	            }
	            if(nums[real]==target){
	                return true;
	            }
	        
	            }
	        return false;
	        
	    }
	/* public boolean search(int[] nums, int target) {
	      int n=nums.length;
	        int start=0;
	        int end=n-1;
	        while(start<=end){
	            int mid=start+(end-start)/2;
	            if(nums[mid]==target)return true;
	            
	            if(nums[mid]<nums[end]){
	                if(nums[mid]<target&&target<=nums[end]){
	                    start=mid+1;
	                }else{
	                    end=mid;
	                }
	            }else if(nums[mid]>nums[end]){
	                  if(nums[mid]>target&&target>=nums[end]){
	                    end=mid;
	                }else{
	                    start=mid+1;
	                }
	            }else{
	                start++;
	            }
	        }
	        return false;
	    }
*/
}
