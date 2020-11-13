package com.hacker;

//https://leetcode.com/discuss/interview-question/474549/How-to-Solve-this-Problem-largest-sub-string-containing-vowels-in-even-counts.-O(n)/423252
public class LongestSubstringEvenVowles {
	public static void main(String[] args) {
		String s1 = "aqwrteakjeaghev";
		String s2 = "aeiou";
		evenCount(s1, s2);

	}

	private static void evenCount(String s1, String s2) {
		// TODO Auto-generated method stub
		int j=0;
		int input[]= new int[26];
		int vowels[] = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == 'a' || s1.charAt(i) == 'e' || s1.charAt(i) == 'i' || s1.charAt(i) == 'o'
					|| s1.charAt(i) == 'u') {
				
				int s = s1.charAt(i) - 'a';
				if(vowels[s]<3) {
					vowels[s]++;
				}
				

			}
		}
		
		for (int i = 0; i < s1.length(); i++) {
			int a=s1.charAt(i)-'a';
			input[a]++;
			
		}
		for (int i = 0; i < vowels.length; i++) {
			
		}
		String s3="";
		String s4="";
		for (int i = 0; i < s1.length(); i++) {
			

			

			int n=s1.charAt(i)-'a';
			int r=vowels[n];
			if(r==2) {
				s3=s3+s1.charAt(i);
			}else if(r>=2) {
				
			}else if(r==1){
				s4=s3;
				s3="";
				
			}else if(r==0) {
				s3=s3+s1.charAt(i);

			}
			
			
		}

	}

	
	
}
