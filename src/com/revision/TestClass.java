package com.revision;

/* IMPORTANT: Multiple classes and nested static classes are supported */

//uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
//import for Scanner and other utility classes
import java.util.*;

//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
		static long gcd(long a, long b)
		{
			if (a == 0) 
				return b;
			
			return gcd(b%a,a);
		}
		static long commDiv(long a,long b)
		{
			long n = gcd(a, b);
		int s=(int) Math.sqrt(n);
			long result = 0;
			for (int i=1; i<=Math.sqrt(n); i++)
			{
				if (n%i==0)
				{
					if (n/i == i)
						result += 1;
					else
						result += 2;
				}
			}
			return result;
		}

	    public static void main(String args[] ) throws Exception {
	        Scanner sc = new Scanner(System.in);
	      //  long a=sc.nextLong();
	        //long b=sc.nextLong();
	        System.out.println(commDiv(20,10));
	    }
	}