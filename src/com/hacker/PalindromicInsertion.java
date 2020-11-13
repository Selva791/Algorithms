package com.hacker;

public class PalindromicInsertion {
	
public static void main(String[] args) {
	String s1="mbadm";
	StringBuffer sb=new StringBuffer("mbadm");
	//mbadm
	//mdabm
	String s2=sb.reverse().toString();
	System.out.println(insertion(s1,s2));
	
}

private static int insertion(String s1, String s2) {
	int pal[][]=new int [s1.length()+1][s2.length()+1];
	for (int i = 0; i < pal.length; i++) {
		for (int j = 0; j < pal.length; j++) {
			if(i==0||j==0) {
				pal[i][j]=0;
			}
			else if(s1.charAt(i-1)==s2.charAt(j-1)) {
				pal[i][j]=pal[i-1][j-1]+1;
			}else  {
				pal[i][j]=Integer.max(pal[i-1][j],pal[i][j-1]);
			}
		}
	}
	return s1.length()-pal[s1.length()][s2.length()];
}
}
