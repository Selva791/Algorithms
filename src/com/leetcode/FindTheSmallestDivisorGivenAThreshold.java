package com.leetcode;

public class FindTheSmallestDivisorGivenAThreshold {
	public static void main(String[] args) {
		FindTheSmallestDivisorGivenAThreshold f=new FindTheSmallestDivisorGivenAThreshold();
		int nums[]= {2,2,2,2};
		int threshold=4;
		f.smallestDivisor(nums, threshold);
	}
	public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(low>nums[i]){
                //low=nums[i];
            }if(high<nums[i]){
                high=nums[i];
            }
        }
        high+=1;
       int div=0,mid=0;
       
       int small=Integer.MAX_VALUE;
        while(low<high){
             mid=low+(high-low)/2;
            div=check(mid,nums);
           
            if(div>threshold){
             low=mid+1;   
            }else if(div<=threshold){
            	small=Math.min(mid, small);
             high=mid;
            }
        }
        return small;
    }
    public int check(int mid,int nums[]){
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            int v1=nums[i]/mid;
            double v2=(double)nums[i]/mid;
            if(v2-v1>0){
                v1+=1;
            }
            sum+=v1;
        }
        return sum;
    }
}
