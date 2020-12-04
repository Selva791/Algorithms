package com.leetcode;

public class CanIWin {
	public static void main(String[] args) {
		CanIWin c=new CanIWin();
		System.out.println(c.canIWin(10, 11));
	}
	  Boolean dp[];
	    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
	        dp=new Boolean[desiredTotal+1];
	        boolean visited[]=new boolean[maxChoosableInteger+1];
	        boolean v= winner(maxChoosableInteger,desiredTotal,visited);
	        return v;
	    }
	    
	    public boolean winner(int max, int total,boolean visited[]){
	      
	        if(total<=0){
	           return false;
	        }
	          if(dp[total]!=null){
	            return dp[total];
	        }
	        boolean w=false;
	        for(int i=1;i<=max;i++){
	            if(!visited[i]){
	                visited[i]=true;
	                System.out.println(i);
	                if(!winner(max,total-i,visited)){
	                	visited[i]=false;
	                    w=true;
	                    break;
	               } 
	                visited[i]=false;
	            }
	          
	            
	        }
	        dp[total]=w;
	        return w;
	    }
}
