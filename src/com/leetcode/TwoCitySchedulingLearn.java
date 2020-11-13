package com.leetcode;

import java.util.Arrays;

public class TwoCitySchedulingLearn {
	public static void main(String[] args) {
		TwoCitySchedulingLearn t=new TwoCitySchedulingLearn();
		int arr[][]= {{10,20},{30,200},{400,50},{30,20}};
		t.twoCitySchedCost(arr);
	}
	public int twoCitySchedCost(int[][] costs) {
        int n=costs.length;
        int profit=0;
        Arrays.sort(costs,(a,b)->(a[0]-a[1])-(b[0]-b[1]));
        
        for(int i=0;i<n;i++){
        	int s[]=costs[i];

            if(i<n/2) {
            	profit+=s[0];
            }else {
            	profit+=s[1];

            }
            
        }
		return profit;
        
    }

}
