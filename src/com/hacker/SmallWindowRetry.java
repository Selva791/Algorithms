package com.hacker;

public class SmallWindowRetry {
	
public static void main(String[] args) {
	 String str = "this is a test string"; 
     String pat = "tist"; 
   
 System.out.print("Smallest window is :\n " + 
                     findSubString(str, pat)); 
}

private static String findSubString(String str, String pat) {
	int l1=str.length();
	int l2=pat.length();
	int count=0;
	int str1[]=new int[256];
	int pat1[]=new int[256];

	for (int i = 0; i < l2; i++) {
		pat1[pat.charAt(i)]++;
		
	}
	int start=0, star_index=0, min_val=l1;
	for (int i = 0; i < l1; i++) {
		str1[str.charAt(i)]++;									//Store the value by converting char into number
		if(pat1[str.charAt(i)]!=0 && str1[str.charAt(i)]<=pat1[str.charAt(i)]) {
			count++;
			
		}
		if(count==l2) {
			while(str1[str.charAt(start)]>pat1[str.charAt(start)] || pat1[str.charAt(start)]==0) {
				if(str1[str.charAt(start)]>pat1[str.charAt(start)]) {
					str1[str.charAt(start)]--;
				}
				start++;
			}
			int len_Window=i-start+1;
			if(min_val>len_Window) {
				min_val=len_Window;
				star_index=start;
							
			}
			
		}
		if(star_index==-1) {
			System.out.println("NO Fuck U");
		}
		
	}
	return str.substring(star_index,star_index+min_val);

}

}
