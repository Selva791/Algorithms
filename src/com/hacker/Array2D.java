package com.hacker;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Array2D {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int j=1;
		List<Integer> li=new ArrayList<>();
	//	System.out.println(arr.length);
    for (int i = 0; i < arr.length; i++) {
    	for (int k = 0; k < arr.length; k++) {
    		if(k+2<=arr.length-1&&i+2<=arr.length-1) {
    		
    		Integer f=arr[i][k]+arr[i][k+1]+arr[i][k+2];
    		f=f+arr[i+1][j++];
    		f=f+arr[i+2][k]+arr[i+2][k+1]+arr[i+2][k+2];
    		li.add(f);
        	
    		}
		}
		j=1;
	}
    Collections.sort(li);
    Collections.reverse(li);
		return (int)li.get(0) ;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
	//int arr[][]=new int [6][6];
	int arrw[][]= {
		{1, 1, 1, 0, 0, 0},
		{0, 1, 0, 0, 0, 0},
		{1, 1, 1, 0, 0, 0},
		{0, 0, 2, 4, 4, 0},
		{0, 0, 0, 2, 0, 0},
		{0, 0, 1, 2, 4, 0},

			
	};
	hourglassSum(arrw);
	}
}
