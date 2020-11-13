package com.leetcode;

public class GasStation {
		public static void main(String[] args) {
			GasStation g=new GasStation();
			int gas[]= {5,1,2,3,4};
			int cost[]= {4,4,1,5,1};
			g.canCompleteCircuit(gas, cost);
		}
		 public int canCompleteCircuit(int[] gas, int[] cost) {
		        int n=gas.length;
		        int m=cost.length;
		        int max=0;
		        int index=0;
		        for(int i=0;i<n;i++) {
		        	max+=gas[i]-cost[i];
		        }
		        if(max<0)return -1;
		        
		        int start=0;
		        int value=gas[index];
		       
		        for(int i=1;i<n;i++){
		            
		            value-=cost[i-1==-1?n-1:i-1];
		            if(value<0) {
		            	start=i+1;
		            	value=0;
		            }
		            
		            value+=gas[i];
		          
		            
		        }
		        return start;
		    }
}
