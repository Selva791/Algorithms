package com.leetcode;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
	public static void main(String[] args) {
		MaxSumOfRectangleNoLargerThanK m=new MaxSumOfRectangleNoLargerThanK();
		
		int mat[][]= {{1,0,1},{0,-2,3}};
		System.out.println(m.maxSumSubmatrix(mat, 2));
	}

	public int maxSumSubmatrix(int[][] matrix, int target) {
		int  n=matrix.length;
		int m=matrix[0].length,val=0,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			
			TreeSet<Integer> tr=new TreeSet<Integer>();
			int add[]=new int[m];
			tr.add(0);
			for(int j=i;j<n;j++) {
				val=0;
				for(int k=0;k<m;k++) {
					add[k]=add[k]+matrix[j][k];
					val+=add[k];
					Integer c=tr.ceiling(val-target);
					if(c!=null) {
					if(val-target==c)return target;
						max=Math.max(max,c-target);
					}
					tr.add(val);
				}
				
			}
			
		}
		return max;
	}
}
