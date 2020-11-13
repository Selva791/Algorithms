package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KokoEatingBananas {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KokoEatingBananas k=new KokoEatingBananas();
		int piles[]= {312884470};
				
		int H=968709470;
		System.out.println(k.minEatingSpeed(piles, H));
	}
	  public int minEatingSpeed(int[] piles, int H) {
	        
	        int total=0;
	        
	        for(int a:piles){
	            total+=a;
	        }
	        
	        int low=total/H;
	        if(H>total)low=1;
	        int high=low;
	        for(int i=0;i<piles.length;i++){
	            if(piles[i]>high){
	                high=piles[i];
	            }
	        }
	       
	        while(low<=high){
	            int mid=low+((high-low)>>1);
	            int t=check(mid,piles,H);
	            
	            if(t>H){
	            	low=mid+1;
	            }else if(t<H){
	            	high=mid-1;
	                
	            }else if(t==H&&min>mid){
	                min=mid;
	               high=mid-1;
	            }
	            if(t<=H&&min>mid) {
	                min=mid;
	            
	            	
	            }
	        }
	            
	        
	        return min;
	    }
	  public int check(int temp,int piles[],int H) {
		  int c=0;
	            for(int i=0;i<piles.length;i++){
	               
	                if(piles[i]>temp){
	                 int r=piles[i]/temp;
	                 int t=temp*r;
	                 int remain=piles[i]-t;
	                 c+=r;
	                  if(remain>0){
	                   c+=1;
	                     
	                 }   
	                }else{
	                    c++;
	                }
	               
	            }
	            return c;
	  }
  int min=Integer.MAX_VALUE;
 
}
