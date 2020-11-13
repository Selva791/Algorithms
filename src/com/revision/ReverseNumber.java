package com.revision;

public class ReverseNumber {
public static void main(String[] args) {
	int n=4532;
	System.out.println(reverse(n));
	
}
static int f=0;
private static int reverse(int n) {
	
	// TODO Auto-generated method stub
	if(n>0) {
	Integer s=n%10;
	f=f*10+s;
	int d=n/10;
	reverse(d);
	}
return Integer.valueOf(f);
		
}
}
