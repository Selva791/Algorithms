package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {
	public static void main(String[] args) {
		FindRightInterval f=new FindRightInterval();
		int intervals [][]= {{1,4},{2,3},{3,4},{6,7}};
		f.findRightInterval(intervals);
	}
	
	public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        Map<Integer,Integer> mp=new HashMap<>();
      int bi[]=new int[n];
        
        for(int i=0;i<n;i++){
           bi[i]=intervals[i][0];
            mp.put(intervals[i][0],i);
        }
        Arrays.sort(bi);
        int [] res=new int[n];
        for(int i=0;i<n;i++){
            int t=intervals[i][1];
            int tp=binarySearch(bi,t);
            if(tp<t) {
            	tp=t;
            }
            int index=mp.getOrDefault(tp,-1);
            res[i]=index;
            
           
            
        }
        return res;
    }
    public int binarySearch(int b[],int t){
        int n=b.length;
        int left=0;
        int right=n-1;
      //  int result=0;
        while(left<right){
            int mid=left+(right-left)/2;
            
            if(b[mid]>t){
                right=mid;
            }else if(b[mid]<t){
                left=mid+1;
            }else{
               return t;
            }
        }
        return b[right];
    }
}