package com.hacker;
//maximum-path-sum-triangle geeks for geeks
public class Diamondshape {
	public static void main(String[] args) {
		 int tri[][] = {{3, 0, 0, 0},       
				       	{7, 4, 0, 0},
				       	{2 ,4, 6, 0},
				       	{8 ,5, 9, 3}};		 
			 	
                        
		 maxPathSum(tri, 3, 3);
 System.out.println();
	}

	private static void maxPathSum(int[][] tri, int r, int w) {
		// TODO Auto-generated method stub
		for (int i = w; i>0; i--) {
			for (int j = 0; j < tri.length; j++) {
				if(tri[i-1][j]!=0) {
					if(tri[i][j]<tri[i][j+1]) {
								int l=tri[i][j+1]+tri[i-1][j];
								tri[i-1][j]=l;

					}else if (tri[i][j]>tri[i][j+1]) {	
						tri[i-1][j]=tri[i][j]+tri[i-1][j];

					}
					
				}
			}
		}
		System.out.println(tri[0][0]);
	}

}
