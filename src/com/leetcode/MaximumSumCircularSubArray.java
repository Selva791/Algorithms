package com.leetcode;

public class MaximumSumCircularSubArray {
public static void main(String[] args) {
	MaximumSumCircularSubArray m=new MaximumSumCircularSubArray();
	int A[]= {-2,-3,-1};//[-2,4,4,4,6] [2,-2,2,7,8,0]
	System.out.println(m.maxSubarraySumCircular(A));
}
public int maxSubarraySumCircular(int[] A) {
	int max_value=kadaneAlgo(A);
	
	int max=0;
	for (int i = 0; i < A.length; i++) {
		max+=A[i];
		A[i]=-A[i];
	}
	
	max=max+kadaneAlgo(A);
	
	return (max>max_value&&max>0)?max:max_value;
			
	
}

    public int kadaneAlgo(int[] A) { 
        int max=0;
      //  int mam=kaden[0];
        int val=Integer.MIN_VALUE;
        int soFar=Integer.MIN_VALUE;
        	for(int j=0;j<A.length;j++){
                     max=max+A[j];
                
                if(soFar<max){
                    soFar=max;                
                } if(max<0){
                    max=0;
                }

                    
               
            }
           
		
        return soFar;
    }
}
