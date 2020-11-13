package com.leetcode;

import java.util.Arrays;

public class PaintHouseIII {
	public static void main(String[] args) {
		PaintHouseIII p = new PaintHouseIII();
		int houses[] = { 0, 2, 1, 2, 0 };
		int cost[][] = { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } };
		int m = 5;
		int n = 2;
		int target = 3;
		System.out.println(p.minCost(houses, cost, m, n, target));

	}
	 /*public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

			int dp[][][] = new int[m][n][target + 1];
			  for (int i = 0; i < m; ++i) {
		            for (int j = 0; j < n; ++j)
		                Arrays.fill(dp[i][j], -1);
		        }
		 int res=helper(houses, cost, m, n, target, dp, 0, 0, -1);
	      if(res==100000000)return -1;
	      return res;

		}

		public int helper(int[] houses, int[][] cost, int m, int n, int target, 
				int dp[][][], int curtarget, int painted,int lastColor) {
			if (painted == m) {
				if (curtarget == target) {
					return 0;
				}
				return 100000000;

			}
			if (curtarget == target+1)
				return 100000000;
			
			if (lastColor != -1) {
				if (dp[painted][lastColor][curtarget] != -1) {
			    return dp[painted][lastColor][curtarget];
				}
			}
			
			int mincost = 100000000;

			for (int i =0; i <n; ++i) {
				boolean isfree=false;
				
				if (houses[painted]!=0) {
					if(houses[painted]!=i+1) {
						continue;
					}else {
						isfree=true;
					}
				}
				
				if (lastColor != i) {
					mincost= Math.min(mincost, helper(houses, cost, m, n, target, dp, curtarget + 1, painted + 1, i)
	                                     +((isfree)?0:cost[painted][i]));
				} else {
					mincost= Math.min(mincost,helper(houses, cost, m, n, target, dp, curtarget, painted + 1,i
	                                                )+((isfree)?0:cost[painted][i]));

				}
			}
	                        System.out.println(mincost);

			if (lastColor != -1) {
				dp[painted][lastColor][curtarget] = mincost;
			}
			return mincost;
		}*/

	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

		int dp[][][] = new int[m][n][target + 1];
		  for (int i = 0; i < m; ++i) {
	            for (int j = 0; j <n; ++j)
	                Arrays.fill(dp[i][j], -1);
	        }
		return helper(houses, cost, m, n, target, dp, 0, 0, -1,0);

	}

	public int helper(int[] houses, int[][] cost, int m, int n, int target, 
			int dp[][][], int curtarget, int painted,int lastColor,int value) {
		System.out.println(value);
		if (painted == m) {
			if (curtarget == target) {
				return value;
			}
			return 100000000;

		}
		if (curtarget == target+1)
			return 100000000;
		
		if (lastColor != -1) {
			if (dp[painted][lastColor][curtarget] != -1) {
				//return dp[painted][lastColor][curtarget];
			}
		}
		
		int mincost = 100000000;

		for (int i =0; i <n; ++i) {
			
			if (houses[painted]!=0) {
				if(lastColor+1!=houses[painted]) {
					curtarget+=1;
				}
				
				lastColor=houses[painted]-1;
				painted+=1;
				continue;
			}
			
			if (lastColor != i) {
				mincost= Math.min(mincost, helper(houses, cost, m, n, target, dp, curtarget + 1, painted + 1, i,value+cost[painted][i]));
			} else {
				mincost= Math.min(mincost,helper(houses, cost, m, n, target, dp, curtarget, painted + 1,i,value+cost[painted][i]));

			}
		}
		if (lastColor != -1) {
			dp[painted][lastColor][curtarget] = mincost;
		}
		return mincost;
	}

}
