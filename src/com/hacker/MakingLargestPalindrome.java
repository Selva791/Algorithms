package com.hacker;

public class MakingLargestPalindrome {
	
	
	private static String maximumPalinUsingKChanges(String str, int k) {
		char data[]=str.toCharArray();
		int n=str.length();
		int p=n-1;
		for (int i = 0; i < k; i++) {
			if((k-i)>1) {
				String str1=str.substring(0,i);
				
				String str2=str.substring(p+1,n);

				str="9"+str.substring(i+1,p)+"9";
				str=str1+str+str2;
				i++;
				p--;
			}else if((k-i)==1){
				StringBuffer stb=new StringBuffer(str);
				if(stb.reverse().toString().equals(str)) {
					if(n%2==1) {
						int m=(n/2) +1;
						str=str.substring(0,n/2)+"9"+str.substring(m,n);
					}
				}else {
					
					System.out.println("NOT POSSIBLE");
				}
			}
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		 String str = "43435"; 
	        int k = 1; 
	        System.out.println(maximumPalinUsingKChanges(str, k)); 
	}


}
