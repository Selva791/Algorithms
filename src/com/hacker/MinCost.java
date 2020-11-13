package com.hacker;
//https://www.geeksforgeeks.org/min-cost-path-dp-6/

public class MinCost {
	public static void main(String[] args) {
		int cost[][] = {{ 1, 2, 3 }, 
						{ 4, 8, 2 },
						{ 1, 5, 3 },
						};

		System.out.print(minCost(cost, 2, 2));
	}
	//******************************** Solution***************************************
	private static int minCost(int[][] cost, int i, int j) {
		int [][]dupe=new int [i+1][j+1];
		dupe[0][0]=cost[0][0];
		for (int k = 1; k <=i; k++) {
			dupe[0][k]=cost[0][k]+dupe[0][k-1];
		}
		for (int j2 = 1; j2 <=j; j2++) {
			dupe[j2][0]=cost[j2][0]+dupe[j2-1][0];
		}
		for (int k = 1; k < dupe.length; k++) {
			for (int k2 = 1; k2 < dupe.length; k2++) {
				dupe[k][k2]=min(dupe[k-1][k2],dupe[k-1][k2-1],dupe[k][k2-1])+cost[k][k2];
				
			}
		}
		return dupe[i][j];
	}


	private static int min(int i, int j, int k) {
		int x=(i<j)?i:j;
		int y=(x<k)?x:k;
		return y;
	}

}


/*
public class GFG { 
	  
     A utility function that returns  
    minimum of 3 integers 
    static int min(int x, int y, int z) 
    { 
        if (x < y) 
            return (x < z) ? x : z; 
        else
            return (y < z) ? y : z; 
    }  
      
     Returns cost of minimum cost path  
    from (0,0) to (m, n) in mat[R][C]
    static int minCost(int cost[][], int m, 
                                     int n) 
    { 
        if (n < 0 || m < 0) 
            return Integer.MAX_VALUE; 
        else if (m == 0 && n == 0) 
            return cost[m][n]; 
        else
            return cost[m][n] +  
                min( minCost(cost, m-1, n-1), 
                     minCost(cost, m-1, n),  
                     minCost(cost, m, n-1) ); 
    } 
  
    // Driver code 
    public static void main(String args[])  
    { 
          
        int cost[][] = { {1, 2, 3}, 
                         {4, 8, 2}, 
                         {1, 5, 3} }; 
                           
        System.out.print(minCost(cost, 2, 2)); 
    } 
} 
 */