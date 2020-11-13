package com.leetcode;

public class MinimumCostOfTickets {
		public static void main(String[] args) {
			MinimumCostOfTickets m=new MinimumCostOfTickets();
			int days []= {1,4,6,7,8,20}, costs[] = {2,7,15};
			System.out.println(m.mincostTickets(days, costs));
		}
		 public int mincostTickets(int[] days, int[] costs) {
		        int n=days.length;
		        int dp[][]=new int[366][n];
		        return helper(days,costs,0,n,dp,0);
		        
		    }
		    public int helper(int[] days, int[] costs,int id ,int n,int dp[][],int total){
		                if(id==n){
		                    return 0;
		                }
		                if(dp[total][id]>0) {
		                	return dp[total][id];
		                }
		                int r=0;
		                if(days[id]<total) {
		                	return helper(days,costs,id+1,n,dp,total);
		                }else {
		                	
		                	int a=helper(days,costs,id+1,n,dp,days[id]+1)+costs[0];
			                int b=helper(days,costs,id+1,n,dp,days[id]+7)+costs[1];
			                int c=helper(days,costs,id+1,n,dp,days[id]+30)+costs[2];
				             r=Math.min(a,Math.min(b,c));

		                }
		                
		             
		            dp[total][id]=r;
		            return r;
		        
		    }
}
