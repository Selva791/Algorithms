package com.hacker;

public class CountStairs {
	
public static void main(String[] args) {
	int s = 4, m = 2; 
    System.out.println("Nuber of ways = " + countWays(s+1, m)); 

}

private static int countWays(int n, int m) {
	int res[]=new int[n];
	// TODO Auto-generated method stub
	res[0]=1; res[1]=1;
	for (int i = 2; i <n; i++) {
		res[i]=0;

		for (int j = 1; j <=m&& j<=i; j++) {
			res[i] += res[i-j];
			
		}
	}
	return res[n-1];
}

}
