package com.hacker;
//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
public class SmallWindow {
	public static void main(String[] args) {
		SmallWindow sm=new SmallWindow();
		String str = "this is a test string"; 
        String pat = "tist"; 
      
    System.out.print("Smallest window is :\n " + 
                        findSubString(str, pat));
	}

	private static String findSubString(String str, String pat) {
		
		int l1=str.length();
		int l2=pat.length();
		char d1[]=str.toCharArray();
		char d2[]=pat.toCharArray();
		for (int i = 0; i < d1.length; i++) {
			int s=0;
			char[] g=d2;
			for (int j = i; j < d1.length; j++) {
				int f=0;
				
				while(f<g.length) {
					
					if(d1[j]==g[f]) {
						g[f]='0';
						f=0;
						break;
					}	
					f++;
				}
				
			}
			
		}
		return null;
	}

}
