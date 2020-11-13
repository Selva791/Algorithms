package com.hacker;

import java.util.Arrays;

public class NextGreaterSet {
	private static void findNext(char[] digits, int n) {
		int i=0;
		for ( i = n-1; i >= 0; i--) {
			if(digits[i]>digits[i-1]) {
				break;
				
			}
		}
		
		if(i==0) {
			System.out.println("NO Possible way");
		}else {
			int min=i;
			
			for (int j = i+1; j < n; j++) {
				
				if(digits[i-1]<digits[j]&&digits[j]<digits[min]) {
					min=j;
							
				}
			}
			char temp=digits[i-1];
			digits[i-1]=digits[min];
			digits[min]=temp;
			Arrays.sort(digits,i,n);
			for (char c : digits) {
				System.out.println(c);
			}
		}
		
		
	}
public static void main(String[] args) {
	 //char digits[] = { '5','3','4','9','7','6' };
	 char digits[] = { '1','2','3','4'}; 

	// Arrays.sort(digits,1,6);
     int n = digits.length; 
     findNext(digits, n); 
}


}
