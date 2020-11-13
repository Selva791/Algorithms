package com.hacker;

public class DiceThrow {
	private static long findWays(int m, int n, int x) {
		// TODO Auto-generated method stub
		long d[][]=new long[n+1][x+1];
		
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <= x; j++) {
				//System.out.println();
				if(i==1) {
					if(j<=m) {
					d[i][j]=1;
					}
				}else if(j>m && d[i-1][j-1]==0) {
					for(int k=1;k<=j&&k<=m;k++) {
						d[i][j]+=(d[i-1][j-k]);
	
					}
				}else {
					d[i][j]=d[i][j-1]+d[i-1][j-1]%1000000007;
				}
			}
		}
		return (d[n][x]);
	}
public static void main(String[] args) {
	 System.out.println(findWays(30, 30, 500)); 
     System.out.println(findWays(2, 2, 3)); 
     System.out.println(findWays(6, 3, 8)); 
     System.out.println(findWays(4, 2, 5)); 
     System.out.println(findWays(4, 3, 5)); 
}


}
