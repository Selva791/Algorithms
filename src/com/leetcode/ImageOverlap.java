package com.leetcode;

public class ImageOverlap {
	public static void main(String[] args) {
		 int A[][] = 
			 	{{1,1,0},
	            {0,1,0},
	            {0,1,0}};
	      int B[][] = 
	    	  	{{0,0,0},
	            {0,1,1},
	            {0,0,1}};
	      ImageOverlap i=new ImageOverlap();
	     System.out.println(i.largestOverlap(A, B));
	}
	 public int largestOverlap(int[][] A, int[][] B) {
         int largestOverlap = 0;
         largestOverlap=Math.max(overLap(A,B),overLap(B,A));   

         return largestOverlap;
     }

    
     public int overLap(int[][] A, int[][] B) {
    	 int count=0;
    	 for (int i = 0; i < A.length; i++) {
    		 for (int j = 0; j < A.length; j++) {
    			 int temp=0;
				for(int x=i;x<A.length;x++) {
					for (int y = j; y < B.length; y++) {
						if(A[x][y]==1&&B[x-i][y-j]==1) {
							temp++;
						}
						
					}
				}
				count=Math.max(temp,count);
			}
			
		}
    	 return count;
     }

}

