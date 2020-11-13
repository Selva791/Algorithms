package com.leetcode;

public class SearchInsertPosition {
	public static void main(String[] args) {
		SearchInsertPosition s=new SearchInsertPosition();
		int nums[]= {1,3,5};
				
			//{1,3} ;
			//{1}; 
			//{1,3,5,6};
		System.out.println("SearchInsertPosition.main() :	"+s.searchInsert(nums, 3));
	}
	public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        if(n==0)return 0;
        if(n==1) {
        	if(nums[0]>target) {
        		return 0;
        	}else {
        		return 1;
        	}
        }
        if(nums[n-1]<=target) {
        	return n;
        }
        int low=0;
        int high=n-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>target){
                high=mid;
                
            }else if(nums[mid]<target){
                low=mid;
                low++;
            }else {
            	return mid
            			;
            }
            
        }
     return low;   
    }
}
