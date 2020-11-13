package com.revision;

import java.util.Scanner;

public class FredoArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long len = s.nextLong();
		long[] array = new long[(int) len];

		// Reading input from STDIN
		for (int i = 0; i < len; i++) {
			array[i] = s.nextInt();
		}
		System.out.println(add(array));
	}

	private static long add(long[] array) {
		// TODO Auto-generated method stub
		long l = array.length;
		long f = 0;
		for (int i = 0; i < l; i++) {
			f = f + array[i];
		}
		long div = f / l;
		long total = div*l;
		if(total<f) {
		while (total < f) {
			div++;
			total = div * l;
			
		}
		}else if(total>f) {
			while (total > f) {
				div--;
				total = div * l;
				
			}	
			
		}else if(total==f) {
			div++;
		}
		return div;
	}

}
