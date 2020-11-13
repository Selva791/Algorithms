package com.hacker;
//https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

public class LongestPalindromicSubSequence {
	public static void main(String[] args) {
		String s="GEEKSFORGEEKS";
		int n=s.length();
		subseq(s.toCharArray(),0,n-1);
		
	}

	private static void subseq(char[] seq, int n, int s) {
		
		int [][] idea=new int[s+1][s+1]; 
		
		for (int i = 0; i < idea.length; i++) {
			idea[i][i]=1;
		}
		for (int j = 0; j < s+1; j++) {
			for (int k = 0; k < s; k++) {
				int i=j+k+1;
						if(i>=s+1) {						
						break;
						}
				if(seq[k]==seq[i]&&j==0) {
					idea[k][i]=2;
					
				}else if(seq[k]==seq[i]) {
					idea[k][i]=idea[k+1][i-1]+2;
					
				}else {
					idea[k][i]=max(idea[k][i-1],idea[k+1][i]);
				}
				
			}
			
			
		}
		System.out.println(idea[0][s]);
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		int x=(i>j)?i:j;
		return x;
	}

}
