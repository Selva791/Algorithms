package com.leetcode;

public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays d=new DecodeWays();
		System.out.println(d.numDecodings("1340"));
	}
	public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuilder temp=new StringBuilder();
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i=2; i<=len; i++){
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            //Its as simple as "dp[i] = dp[i-1] + dp[i-2]" 
            //its just that we need to have one digit and 2 digit conditions before adding
            if(oneDigit > 0)
                dp[i] = dp[i-1];
            if(twoDigit >=10 && twoDigit <=26)
                dp[i] = dp[i]+dp[i-2];
        }
        return dp[len];
    }
}
