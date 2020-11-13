package com.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class BestTimeToSellStockIII {
	public static void main(String[] args) {
		BestTimeToSellStockIII b=new BestTimeToSellStockIII();
		System.out.println(b.maxProfit(new int[] {3,3,5,0,0,3,1,4}));
        

	}
	 public int maxProfit(int[] prices) {
	        int n=prices.length;
	        if(n==0)return 0;
	        
	        int low=Integer.MAX_VALUE;
	        int temp=0;
	        int start=0;
	        int end=0;
	        int profit=0;
	        for(int i=0;i<n;i++){
	            if(prices[i]<low){
	                low=prices[i];
	                start=i;
	            }else{
	                temp=prices[i]-low;
	            }
	            if(temp>profit){
	                end=i;
	             profit=temp;
	            }
	        }
	        int r=(end-start)+1;
	        int decide[]=new int[n-r];
	        int m=decide.length;
	        int k=0;
	        for(int i=0;i<n;i++){
	            if(i<start||i>end){
	                decide[k]=prices[i];
	                k++;
	            }
	            
	        }
	         int less=Integer.MAX_VALUE;
	        int count=0;
	            int prof=0;
	         for(int i=0;i<n;i++){
	            if(decide[i]<less){
	                less=decide[i];
	            }else{
	                count=prices[i]-prices[less];
	            }
	            if(temp>prof){
	             prof=count;
	            }
	        }
	        System.out.println(prof+" "+profit);
	    return (prof+profit);
	            }
}
