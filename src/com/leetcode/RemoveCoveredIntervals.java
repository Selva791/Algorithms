package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveCoveredIntervals {
   public static void main(String[] args) {
	   RemoveCoveredIntervals r=new RemoveCoveredIntervals();
	   int[][]intervals= {{1,4},{3,6},{2,8}};
	   	System.out.println(r.removeCoveredIntervals(intervals));
}
   
   public int removeCoveredIntervals(int[][] A) {
       int res = 0, left = -1, right = -1;
       Arrays.sort(A, (a, b) -> a[0] - b[0]);
       
       for (int[] v : A) {
           if (v[0] > left && v[1] > right) {
               left = v[0];
               ++res;
           }
           right = Math.max(right, v[1]);
       }
       return res;
   }
   /*public int removeCoveredIntervals(int[][] intervals) {
       Arrays.sort(intervals,(a,b)->(a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]));
       int n=intervals.length;
       int count=0;
       Set<Integer> cache=new HashSet<>();
       for(int i=0;i<n;i++){
           int t1[]=intervals[i];
           for(int j=i+1;j<n;j++){
               int t2[]=intervals[j];
               if(t2[1]<=t1[1]&&!cache.contains(j)){
            	   cache.add(j);
                   count++;
               }
           }
       } 
      // System.out.println(count);
       return n-count<0?count-n:n-count;
   }*/
}
