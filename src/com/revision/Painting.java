package com.revision;

public class Painting {
public static void main(String[] args) {
	int c[][]= {{0, 0,  0},
				{0, 100, 20},
				{0, 30 , 59},
				{0, 71  ,81},
				{0, 9 ,  200}};

	int N=4;//no.of bildings
	int M=2;//paint types
	int k=1;//Specialiy
	int sp[]={0, 0, 0, 2};
        paintCost(c,N,M,k,sp);
	
}

private static void  paintCost(int[][] c, int n, int m, int k,int sp[]) {
	// TODO Auto-generated method stub
	int splen=sp.length;
			
	int dp[][][]=new int[n+1][k+1][m+1];
	for(int i=1;i<n+1;i++) {
		for (int j = 1; j <m+1 ; j++) {
			for (int t = 1; t<splen+1; t++) {
				if(sp[t]==sp[t-1]) {
					dp[i-1][j][t]=dp[i - 1][j][t] + c[i][t];
				}else {
					int p=k+1;
					dp[i-1][j-1][t]=dp[i - 1][j - 1][p] + c[i][t];
				}
			}
		}
		
	}
	
}
}
