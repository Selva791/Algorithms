package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	public static void main(String[] args) {
		MajorityElementII m=new MajorityElementII();
		int nums[]= {1,2};
		System.out.println(m.majorityElement(nums));
	}

	 public List<Integer> majorityElement(int[] nums) {
	        List<Integer> result=new ArrayList();
	        int n=nums.length;
	        if(n==0)return result;
	        int t1=nums[0];
	        int t2=nums[0];
	        int count1=0;
	        int count2=0;
	        for(int a:nums){
	            
	            if(t1==a){
	               count1++; 
	            }else if(t2==a){
	                count2++;
	            }else if(count1==0){
	                t1=a;
	                count1=1;
	            }else if(count2==0){
	                t2=a;
	                count2=1;
	            }else{
	                count1--;
	                count2--;
	            }
	            
	        }
	        count1=0;
	        count2=0;
	        for(int b:nums){
	            if(t1==b)count1++;
	            else if(t2==b)count2++;
	        }
	        if(count1>n/3){
	           result.add(t1);
	        }else if(count2>n/3){
	            result.add(t2);
	        }
	        return result;
	    }
}
