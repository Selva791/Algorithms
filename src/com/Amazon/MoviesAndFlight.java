package com.Amazon;

import java.util.Arrays;

public class MoviesAndFlight {
	public static void main(String[] args) {
		int [] nums =  new int [] {90, 85, 75, 60, 120, 150, 125};
		int d = 250;
		int[] result = sumclosest(nums,d);
		System.out.println(result[0]+"  "+result[1]);
	}

	private static int[] sumclosest(int[] nums, int d) {
			int [] result = new int [2];
			if( nums == null || nums.length==0|| d<30){
				return result;
			}
			
			int max = Integer.MIN_VALUE;
			Arrays.sort(nums);
			int i=0; int j = nums.length-1;
			
			while(i<j){
		        if(nums[i]+nums[j]<d-30){
		        	if((nums[i]+nums[j])>max){
						max = nums[i]+nums[j];
						result[0] =nums[i];
						result[1] =nums[j];
					}
		        	i++;
		        }else if(nums[i]+nums[j]>d-30){
		        	j--;
		        }
		        else{
		        	result[0] =nums[i];
					result[1] =nums[j];
					break;
		        }			
			}
			return result;
	}
	
}
