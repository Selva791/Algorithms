package com.Amazon;

public class RollDice {
	public static void main(String[] args) {
        int[] A = {6, 6, 1};
        	//{6,1,5,4}; 
        	//{6,5,4};
        	//{3,4,1,2,4,2,3,5,1,2,3,4,6,2,4,1,5,2};
        RollDice r=new RollDice();
        System.out.println(r.roll(A));

	}

	private int roll(int[] a) {
		int n=a.length;
		int pos[]=new int[7];
		for(int i=0;i<n;i++) {
			pos[a[i]]+=1;
			
			
		}
		int max=Integer.MAX_VALUE;
		for(int i=1;i<=6;i++) {
			int flip=0;
			for(int j=1;j<=6;j++) {
				if(i+j==7) {
					flip+=2*pos[j];
				}else if(j!=i){
					flip+=pos[j];
				}
				
			}
			if(flip<max) {
				max=flip;
			}
			
		}
		return max;
	}

}
