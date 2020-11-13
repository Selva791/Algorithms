package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NextGreaterElementI {
	public static void main(String[] args) {
		NextGreaterElementI n=new NextGreaterElementI();
		int nums1[]= {4,1,2};
		int nums2[] ={1,3,4,2};
		n.nextGreaterElement(nums1, nums2);
	}
	 public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	        Map<Integer,Integer> mp=new HashMap<>();
	        boolean flag=false;
	        int n=nums2.length;
	        for(int i=0;i<n;i++){
	            mp.put(nums2[i],i);
	        }
	        for(int i=0;i<nums1.length;i++){
	            int t=mp.getOrDefault(nums1[i],-1);
	           
	                if(t>-1){
	                     int v=nums2[t];
	                     for(int j=t;j<n;j++){
	                     if(nums2[j]>v){
	                       nums1[i]=nums2[j];
	                       flag=true;
	                        break;
	                    }
	                   }
	                    if(!flag)nums1[i]=-1;
	                    else flag=false;
	                        
	                 }
	        }
	        return nums1;
	    }
}
