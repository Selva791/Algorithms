package com.revision;

public class RecursionCheck {
	public static void main(String[] args) {
		int []mat= {6,7,8,9};
		caller(mat,0);
		System.out.println();
	}

	private static void caller(int[] mat,int i) {
		if(i>=0&&i<mat.length) {
			mat[i]=0;
			caller(mat, i+1);
		}
		System.out.println("");
	}

}
