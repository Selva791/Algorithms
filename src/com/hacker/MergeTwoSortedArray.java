package com.hacker;

import java.util.Arrays;

public class MergeTwoSortedArray {
	public static void main(String[] args) {
		int[] a1 = { 10, 27, 38, 43 ,82 }; 
        int[] a2 = { 3,9 }; 
  
       System.out.println(Arrays.asList(merge(a1, a2, a1.length, a2.length)));

        System.out.print("First Array: "); 
        for (int i = 0; i < a1.length; i++) { 
            System.out.print(a1[i] + " "); 
        } 
          
        System.out.println(); 
          
        System.out.print("Second Array: "); 
        for (int i = 0; i < a2.length; i++) { 
            System.out.print(a2[i] + " "); 
        } 
	}

	private static int[] merge(int[] a1, int[] a2, int length, int length2) {
		int len=length+length2;
		int gap=len/2;
		int a[]= new int[len];
		int i=0;
		for ( i = 0; i < a1.length; i++) {
			if(i<a1.length) {
			a[i]=a1[i];
			}
		}
		int k=0;
		for(;i<len;i++) {
			a[i]=a2[k];
			k++;
		}
		
		while(gap>=1) {
			for (int m = 0; m< a.length; m++) {
				int j=m+gap;
				if(j<len&&a[j]<a[m]) {
					swap(a,j,m);
				}
				
			}
		gap--;
		}
		return a;
	}

	private static void swap(int[] a, int j, int m) {
		int temp=a[m];
		a[m]=a[j];
		a[j]=temp;
		
	}

}
