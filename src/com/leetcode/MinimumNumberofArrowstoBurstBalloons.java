package com.leetcode;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {
		public static void main(String[] args) {
			MinimumNumberofArrowstoBurstBalloons m=new MinimumNumberofArrowstoBurstBalloons();
			int points[][]= {{-2147483646,-2147483645},{2147483646,2147483647}};
			m.findMinArrowShots(points);
		}
		 public int findMinArrowShots(int[][] points) {
		        
		        Arrays.sort(points,(a,b)->Integer.compare(a[1], b[1]));
		        int n=points.length;
		        if(n==0)return 0;
		        int prev[]=points[0];
		        int count=1;
		        for(int i=1;i<n;i++){
		            int temp[]=points[i];
		            if(prev[1]>=temp[0]){
		                
		            }else{
		                count++;
		                prev=temp;
		            }
		            
		            
		        }
		        return count;
		    }
}
