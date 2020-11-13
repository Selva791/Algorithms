package com.revision;

public class LCMandGCD {
public static void main(String[] args) {
	lcm(15,20);
}

private static void lcm(int i, int j) {
	// TODO Auto-generated method stub
	int lcm=(i*j)/gcd(i,j);
	System.out.println(gcd(i,j)+" "+lcm);
}

private static int gcd(int i, int j) {
	// TODO Auto-generated method stub
	if(i==0) {
		return j;
	}
	return gcd(j%i,i);
}
}
