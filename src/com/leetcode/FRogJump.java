package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FRogJump {
	public static void main(String[] args) {
		FRogJump f=new FRogJump();
		int []stones= {0,1,2,3,4,8,9,11};
					// 0 1 2 3 4 5 6  7
        Arrays.sort(stones);

		System.out.println(f.canCross(stones));
	}
	 public boolean canCross(int[] stones) {
	        int n=stones.length;
	        if(n==0)return false;
	        if(n==1)  	return true;
	        if (stones[1] != 1) {return false;}

	        if(n==2) {
	        	if(stones[1]>1)return false;
	        	else if(stones[1]==1) return true;
	        }
	        
	        List<Integer> list=new ArrayList<>();
	       for(int i=0;i<n;i++) {
	            if (i > 3 && stones[i] > stones[i - 1] * 2) {return false;} // The two stones are too far away. 

	    	   list.add(stones[i]);
	       }
	       
	       return  helper(stones[n-1],1,1,list);       
	    }
	  public boolean  helper(int last,int index,int count,List<Integer> list){
	     // if(index>=list.size())return false;
	      
	        if(count+index+1==last||count+index-1==last||count+index==last){
	            return true;
	        }
	        
	        	if(list.contains(count+index+1)){
	        		if(helper(last,count+index+1,count+1,list))return true;
	        	}if(list.contains(count+index)){
	  	          if(helper(last,count+index,count,list))return true;

	        	}if(count>1&&list.contains(count+index-1)){
	  	          if(helper(last,count+index-1,count-1,list))return true;
		        }
	        
	        return  false;        
	    }
}
