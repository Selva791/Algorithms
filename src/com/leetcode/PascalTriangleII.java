package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
	public static void main(String[] args) {
		PascalTriangleII p=new PascalTriangleII();
		System.out.println(p.getRow(3));
	}
	public List<Integer> getRow(int rowIndex) {
	Integer res[]=new Integer[rowIndex+1];
	res[0]=1;
		for (int i = 1; i <=rowIndex; i++) {
			res[i]=1;

			for(int j=i-1;j>=1;j--) {
				res[j]=res[j]+res[j-1];
			}
		}
		

		return Arrays.asList(res);
	     
	    }
}
