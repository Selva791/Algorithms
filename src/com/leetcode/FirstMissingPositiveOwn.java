package com.leetcode;

public class FirstMissingPositiveOwn {
	public static void main(String[] args) {
		FirstMissingPositiveOwn f=new FirstMissingPositiveOwn();
		int nums[]= {3,4,-1,1};
		f.firstMissingPositive(nums);
	}
	public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int result[]=new int[n+1];
        for(int i=1;i<=n;i++){
            result[i]=i;
        }
        int sum=(n*(n+1))/2;
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(nums[i]<=0||nums[i]>n){
                nums[i]=1;
            }else if(nums[i]==1){
                flag=true;
            }
        }
        if(!flag)return 1;
        
        for(int i=0;i<n;i++){
            result[nums[i]]-=result[nums[i]];
        }
        
        for(int i=0;i<=n;i++){
            if(result[i]>0){
                return i;
            }
        }
        return n+1;
    }

}
