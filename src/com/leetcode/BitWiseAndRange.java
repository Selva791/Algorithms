package com.leetcode;
//https://leetcode.com/problems/bitwise-and-of-numbers-range/submissions/

public class BitWiseAndRange {
public static void main(String[] args) {
	BitWiseAndRange r=new BitWiseAndRange();		
	System.out.println(r.rangeBitwiseAnd(16, 19));
}
public int rangeBitwiseAnd(int m, int n) {
    int count=0;
    while(m!=n){
        m=m>>1;
        n=n>>1;			//>> (Right Shit operator) reduce the lenght of n by 1 here
        count++;
    }
   int c= m<<count; //<< (left shift operator)add two zero based on count
    return c;
}
/*
0000000-0
0000001-1
0000010-2
0000011-3
----------
0000100-4
0000101-5
0000110-6
0000111-7
-----------
0001000-8
0001001-9
0001010-10*/
}
