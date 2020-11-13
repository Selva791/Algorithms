package com.hacker;

public class IsInterLeavedString {
	public static void main(String[] args) {
	System.out.println(interLeaved("aab","axy","aaxaby"));
	}

	private static boolean interLeaved(String str1, String str2, String str3) {
		boolean t[][]=new boolean[str1.length()+1][str2.length()+1];
		for (int i = 0; i <=str1.length(); i++) {
			
			for (int j = 0; j <=str2.length(); j++) {
				int l=i+j-1;
				if(i==0&&j==0) {
					t[i][j]=true;
					
				}
				else if(j==0) {
						if(str3.charAt(l)==str1.charAt(i-1)) {
					t[i][j]=t[i-1][j];
					
				}
				}else if(i==0) {
				if(str3.charAt(l)==str2.charAt(j-1)) {
					t[i][j]=t[i][j-1];
					
				}
				}else {
					if(str3.charAt(l)==str1.charAt(i-1)) {
					t[i][j]=t[i-1][j];
					}
					else if(str3.charAt(l)==str2.charAt(j-1)) {
						t[i][j]=t[i][j-1];

					}else {
						t[i][j]=false;
					}

				}
				
			}
		}
		
		return t[str1.length()][str2.length()];
	}

}
