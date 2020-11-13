package com.revision;

public class PalindromicPartition {
	
public static void main(String[] args) {
	String str = "ababbbabbababa"; 
    System.out.println("Min cuts needed for "
                       + "Palindrome Partitioning"
                       + " is " + minPalPartion(str)); 
}

private static String minPalPartion(String str) {
	boolean c[][]=new boolean [str.length()][str.length()];
	for (int i = 0; i < c.length; i++) {
		c[i][i]=true;
	}
	int a[]=new int[str.length()];
	for (int i = 2; i < c.length; i++) {
		for (int j = 0; j < c.length; j++) {
			int k=i+j-1;
			if(i==2&&c[j][k-1]) {
				c[j][k]=true;
			}
			else if(str.charAt(j)==str.charAt(k)&&c[j+1][k-1]){
				c[j][k]=true;
			}
			
		}
	}
	
	for (int i = 0; i < c.length; i++) {
		if(c[0][i]==true) {
			a[i]++;
		}
		else {
			for (int j = 0; j < i; j++) {
				if(c[j+1][i]==true) {
					a[i]++;
				}
			}
		}
		
	}
	return null;
}
}
