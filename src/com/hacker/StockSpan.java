package com.hacker;

import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/the-stock-span-problem/
public class StockSpan {
	
	private static void calculateSpan(int[] price, int n, int[] s) {
		s[0]=1;
		for (int i = 1; i < price.length; i++) {
			int conter=1;
			
			while ((i-conter)>=0&&price[i-conter]<price[i]) {
				conter+=s[i-conter];
				
			}
			s[i]=conter;
		}
		
	}
public static void main(String[] args) {
	int price[] = { 10, 4, 5, 90, 120, 80 }; 
    int n = price.length; 
    int S[] = new int[n]; 

    // Fill the span values in array S[] 
    calculateSpan(price, n, S); 
    Arrays.stream(S).forEach(s->System.out.println(s));
   
}


}
