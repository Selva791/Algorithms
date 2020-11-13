package com.leetcode;

public class ChampagneTower {
	public static void main(String[] args) {
		ChampagneTower c=new ChampagneTower();
		System.out.println(c.champagneTower(159,20,4));
	}

	int poured;
	Double dp[][];
	int r=0,c=0;
	public double champagneTower(int poured, int query_row, int query_glass) {
		this.poured = poured;
		r=query_row;
		c=query_glass;
		this.dp = new Double[query_row + 1][query_glass + 1];
		double r=bottomChampagne(0, 0,poured);
		return Math.min(1, r);
	}

	public double bottomChampagne(int r1, int c1,double div) {
		if(div<0||div==0) {
			return 0;
		}
		if (r1>r||c1>r1||c<c1) {
			return div;
		}

		if (r1 == r && c1 == c) {
			return 0;
		}
		if (dp[r1][c1] != null) {
			return dp[r1][c1];
		}

		double t =bottomChampagne(r1+1,c1,(div-1)/2)+bottomChampagne(r1+1,c1+1,(div-1)/2);
		

		dp[r1][c1] = t;
		return t;
	}
}
