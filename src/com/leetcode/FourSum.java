package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
public static void main(String[] args) {
	FourSum f=new FourSum();
	//[0,0,0,0]
	int arr[]= {0,0,0,0};
		//{1, 0, -1, 0, -2, 2};
	System.out.println(f.fourSum(arr, 0));
	
}
public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int n=nums.length;
    List<List<Integer>> result=new ArrayList<>();
    
    for(int i=0;i<n;i++){
        int cur=target-nums[i];
       
     for(int j=i+1;j<n;j++){
          int low=j+1;
          int high=n-1;
          cur=target-nums[i]-nums[j];
         while(low<high){
             if(nums[low]+nums[high]==cur){
                 result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                 while(low<high&&nums[low]==nums[low+1])low++;
                 while(low<high&&nums[high]==nums[high-1])high--;
               
                 low++;
                 high--;
             }else if(nums[low]+nums[high]>cur){
                 high--;
             }else{
                 low++;
             }
             
         }
         
     }
            
        
    }
    return result;
}
}
