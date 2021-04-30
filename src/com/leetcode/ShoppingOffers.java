package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {
	public static void main(String[] args) {
		ShoppingOffers s = new ShoppingOffers();
		List<Integer> price =new ArrayList<>();
		price.add(2);
		price.add(5);
		 List<List<Integer>> special =new ArrayList<>();
		 special.add(Arrays.asList(3,0,5));
		 special.add(Arrays.asList(1,2,10));
		 List<Integer> needs=new ArrayList<Integer>();
		 needs.add(3);
		 needs.add(2);
		System.out.println(s.shoppingOffers(price, special, needs));
	}
	  int ans=Integer.MAX_VALUE,ans2=Integer.MAX_VALUE;
	    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	        int n=needs.size();
	        int maxPrice=0;
	      
	        int[] need=new int[n];
	        for(int j=0;j<n;j++){
	            need[j]=needs.get(j);
	        }
	       shop(price,special,need,maxPrice,0);
	     
	        
	        
	        return ans;
	    }
	    public void shop(List<Integer> price, List<List<Integer>> special, int[]needs,int max,int cnt){
	        
	            int v=stopper(needs,price,cnt);
	            ans=Math.min(ans,v);
	            if(v==cnt)return;
	            
	        for(int i=0;i<special.size();i++){
	            List<Integer> sp=special.get(i);
	            int m=sp.size()-1;
	            if(check(sp,needs)){
	                process(sp,needs);
	            if(cnt+sp.get(m)<ans){
	                shop(price,special,needs,max,cnt+sp.get(m));
	            }  
	                reProcess(sp,needs);
	            }
	            
	        }
	       
	    }
	    public boolean check(List<Integer> sp, int[]needs){
	        for(int j=0;j<sp.size()-1;j++){
	                if(needs[j]>=sp.get(j)){
	                    
	                }else{
	                  return false;
	                }
	            }
	        return true;
	    }
	     public void process(List<Integer> sp, int[]needs){
	        for(int j=0;j<sp.size()-1;j++){
	              needs[j]=needs[j]-sp.get(j);
	            }
	        return;
	    }
	     public void reProcess(List<Integer> sp, int[]needs){
	        for(int j=0;j<sp.size()-1;j++){
	              needs[j]=needs[j]+sp.get(j);
	            }
	        return;
	    }
	    public int stopper(int[] needs,List<Integer> price,int c){
	    	
	        for(int i=0;i<needs.length;i++){
	        	int a=needs[i];
	            if(a!=0) {
	            	c+=(a*price.get(i));
	            }
	        }
	        return c;
	    }
	
}
