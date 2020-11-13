package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StoneGameIV {
	public static void main(String[] args) {
		StoneGameIV s = new StoneGameIV();
		System.out.println(s.winnerSquareGame(7));
	}

	
	  Boolean[] dp = new Boolean[100001];
	    public boolean winnerSquareGame(int n) {
	        if(n == 0) return false;
	        
	        if(dp[n] != null) return dp[n];
	        boolean winner = false;
	        for(int i = 1; i * i <= n; i++) {
	            if(!winnerSquareGame(n - i * i)) {
	            	
	                winner = true;
 	                break;
	                
	            }
	        }
	        return dp[n] = winner;
	    }
}
