package com.leetcode;

public class PredictTheWinner {
	public static void main(String[] args) {
		PredictTheWinner p=new PredictTheWinner();
		int nums[]= {1,5,233,7};
		p.PredictTheWinner(nums);
	}

	// Similar problem is available in leetcode
	int dp[][];

	public boolean PredictTheWinner(int[] nums) {
	        int n=nums.length;
	        dp=new int[n+1][n+1];
	        
	         int v=Predict(nums,0,n-1,0);
	         
	         return v>0;
	    }

	public int Predict(int nums[], int start, int end, int play) {
		if (start >end) {
			return 0;
		}

		int v1 = 0, v2 = 0;
		if (play == 0) {
			dp[start][end] = Math.max(Predict(nums, start + 1, end, 1) + nums[start], Predict(nums, start, end - 1, 1) + nums[end]);
		}
		else if (play == 1) {
			dp[start][end]  = Math.min(Predict(nums, start + 1, end, 0) - nums[start], Predict(nums, start, end - 1, 0) -nums[end]);
		}
		
		//dp[start][end] = v;
		return dp[start][end] ;

	}
}
