package com.hacker;

public class WildCardPatternMatchingDynamicProgramming {
	private static boolean strmatch(String str, String pattern, int n, int m) {
		boolean[][] lookup = new boolean[n + 1][m + 1];
		lookup[0][0] = true;

		for (int i = 1; i < m + 1; i++) {
			if (pattern.charAt(i - 1) == '*') {
				lookup[0][i] = lookup[0][i - 1];

			}

		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if(pattern.charAt(j-1)=='*') {
					lookup[i][j]=lookup[i-1][j]||lookup[i][j-1];
					
				}else if(pattern.charAt(j-1)=='?'||str.charAt(i-1)==pattern.charAt(j-1)) {
					lookup[i][j]=lookup[i-1][j-1];
					
				}

			}
		}
		return lookup[n][m];
	}

	public static void main(String[] args) {
		String str = "baaabab";
		String pattern = "*****ba*****ab";
		// String pattern = "ba*****ab";
		// String pattern = "ba*ab";
		// String pattern = "a*ab";
		// String pattern = "a*****ab";
		// String pattern = "*a*****ab";
		// String pattern = "ba*ab****";
		// String pattern = "****";
		// String pattern = "*";
		// String pattern = "aa?ab";
		// String pattern = "b*b";
		// String pattern = "a*a";
		// String pattern = "baaabab";
		// String pattern = "?baaabab";
		// String pattern = "*baaaba*";

		if (strmatch(str, pattern, str.length(), pattern.length()))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
