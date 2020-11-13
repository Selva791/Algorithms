package com.leetcode;

public class BestTimetoBuyAndSellStockWithCooldown {
		public static void main(String[] args) {
			int[] prices= {1,3,2,0,1};
			BestTimetoBuyAndSellStockWithCooldown b=new BestTimetoBuyAndSellStockWithCooldown();
			System.out.println(b.maxProfit(prices));
		}
		public int maxProfit(int[] prices) {
	        int len = prices.length;
	        if (len < 2) return 0;
	        int[] sell = new int[len];
	        int[] buy  = new int[len];

	        buy[0]  = -prices[0];
	        buy[1]  = -Math.min(prices[0], prices[1]);
	        sell[1] = Math.max(0, buy[0] + prices[1]);

	        for (int i = 2; i < len; i++){
	            buy[i]  = Math.max(buy[i - 1], sell[i - 2] - prices[i]);//profit because of buy
	            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);//total profit will carry forward from each step
	        }
	        return sell[len - 1];
	    }
		
		/*public int maxProfit(int[] prices) {
		    int len = prices.length;
		    if (len <= 1) {
		        return 0;
		    }
		   
		    int[] s0 = new int[len]; //start state (or state after rest)
		    int[] s1 = new int[len]; //state after buying
		    int[] s2 = new int[len]; //state after selling

		    s0[0] = 0;
		    s1[0] = -prices[0];
		    s2[0] = Integer.MIN_VALUE;

		    for (int i = 1; i < len; i++) {
		         for current state of s0, we may stay on s0 state to rest many days, or transfer from s2 state to rest one day 
		        s0[i] = Math.max(s0[i - 1], s2[i - 1]);

		         for current state of s1, we may stay on s1 state to rest many days (wait better opportunity to buy), or transfer from s0 state to buy at current price 
		        s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);

		         for current state of s2, we may stay on s2 state to rest many days (wait better opportunity to sell), or transfer from s1 state to sell (at current price) on the second day after buying 
		        s2[i] = Math.max(s2[i - 1], s1[i - 1] + prices[i]);
		    }
		    return Math.max(s0[len - 1], s2[len - 1]);
		}*/
		/*public int maxProfit(int[] prices) {
		      int[][] memo = new int[2][prices.length];  
		      return helper(prices , 0 , 0 , memo);  
		    }
		    
		    
		    private int helper(int[]prices, int index, int flag , int[][]memo){
		        
		        if(index >= prices.length)return 0;
		        
		        if(memo[flag][index] != 0){
		            return memo[flag][index];
		        }
		        
		         int profit = 0 , buy = 0 , noBuy = 0 , sell = 0 , noSell = 0;
		        
		        if(flag == 0){
		             buy = helper(prices , index + 1 , 1 , memo) - prices[index];
		             noBuy = helper(prices , index + 1 , 0 , memo);
		        }else{
		             sell = helper(prices , index + 2 , 0 , memo) + prices[index];
		             noSell = helper(prices , index + 1 , 1 , memo);
		        }
		        profit = Math.max(Math.max(buy,noBuy),Math.max(sell,noSell));
		        memo[flag][index] = profit;
		       return profit; 
		    }*/
		    
}
