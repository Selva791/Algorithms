package com.leetcode;

public class MinimumCostForTicketsDynamicProgramming {
public static void main(String[] args) {
	MinimumCostForTicketsDynamicProgramming dp=new MinimumCostForTicketsDynamicProgramming();
	int days[]= {1,4,6,7,8,20};
	int costs[]= {2,7,15};
	System.out.println(dp.mincostTickets(days, costs));
}
public int mincostTickets(int[] days, int[] costs) {
    int n=days.length;
    if(n==0)return 0;
    int dp[]=new int[366];
    boolean travel[]=new boolean[366];
    int max=days[n-1];
    for(int i=0;i<n;i++){
            travel[days[i]]=true;
    }
    
    for(int i=1;i<366;i++){
        if(i<=max&&travel[i]){
           int a=dp[Math.max(0,i-1)]+costs[0];
           int b=dp[Math.max(0,i-7)]+costs[1];
           int c=dp[Math.max(0,i-30)]+costs[2];
           int min=Math.min(a,Math.min(b,c));
            dp[i]=min;
            
        }else if(i<=max) {
            dp[i]=dp[i-1];
        }else {
        	break;
        }
        
    }
    return dp[days[days.length-1]];
}
}
