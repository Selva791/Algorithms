package com.hacker;

public class EditDistance {
	private static int editDistDP(String str1, String str2, int length, int length2) {
		int t[][]=new int [length2+1][length+1];
		for (int i = 0; i < length+1; i++) {
			t[0][i]=i;
		}for (int i = 0; i < length2+1; i++) {
			t[i][0]=i;
		}
		for (int i = 1; i < length2+1; i++) {
			for (int j = 1; j < length+1; j++) {
				if(str2.charAt(i-1)==str1.charAt(j-1)) {
					t[i][j]=t[i-1][j-1];
					
				}
				if(str2.charAt(i-1)!=str1.charAt(j-1)) {
					t[i][j]=1+mini(t[i-1][j-1],t[i-1][j],t[i][j-1]);

				}
			}
		}
		return t[length2][length];
	}
	
private static int mini(int i, int j, int k) {
	int s1=(i<j)?i:j;
	int s2=(s1<k)?s1:k;

		return s2;
		
	}

public static void main(String[] args) {

    String str1 = "sunday"; 
    String str2 = "saturday"; 
    System.out.println("Edited Dist : "+editDistDP(str1, str2, str1.length(), str2.length())); 

}


}
