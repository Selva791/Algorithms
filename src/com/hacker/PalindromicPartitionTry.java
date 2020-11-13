package com.hacker;

public class PalindromicPartitionTry {
	public static void main(String[] args) {
		String str = "ababbbabbababa"; 
        System.out.println("Min cuts needed for "
                           + "Palindrome Partitioning"
                           + " is " + minPalPartion(str)); 
	}

	private static int minPalPartion(String str) {
		int len=str.length();
		boolean [][] pal=new boolean [len][len];
		int c[][]=new int[len][len];
		for (int i = 0; i < len; i++) {
			pal[i][i]=true;	
			c[i][i]=0;
			
		}
		int i,k;
		for (int L = 2; L <=len; L++) {
			
			for (int j = 0; j <len-L+1; j++) {
				i=L+j-1;
				if(L==2) {
					pal[j][i]= (str.charAt(i)==str.charAt(j));
					
				}else {
					pal[j][i]= (str.charAt(i)==str.charAt(j))&& pal[j+1][i-1];
				}
				
				if(pal[j][i]==true) {
					c[j][i]=0;
				}else {
					c[j][i]=Integer.MAX_VALUE;
					for (k=j;k<=i-1;k++) {
						c[j][i]=Integer.min(c[j][i],1+c[j][k]+c[k+1][i]);
						
					}
			}
				
		

			}	
			
			
		}
		return c[0][len-1];
	}

}
