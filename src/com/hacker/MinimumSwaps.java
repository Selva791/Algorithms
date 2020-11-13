 package com.hacker;

public class MinimumSwaps {
	public static void main(String[] args) {
		
		// For simplicity, it is assumed that arr[0] is
		// not used. The elements from index 1 to n are
		// only valid elements
		int arr[] = {2,0,5,4,3,1};
			//{ 0, 3, 5, 6, 4, 1, 2 };

		// if (a, b) is pair than we have assigned elements
		// in array such that pairs[a] = b and pairs[b] = a
		int pairs[] = {1,0,3,2,5,4};
			//{ 0, 3, 6, 1, 5, 4, 2 };
		int m = pairs.length;

		// Number of pairs n is half of total elements
		int n = m / 2;
		//System.out.println(3 ^ 9 ^ 3);
		// If there are n elements in array, then
		// there are n pairs
		System.out.print("Min swaps required is " + minSwaps(n, pairs, arr));

	}

	private static int minSwaps(int n, int[] pairs, int[] arr) {
		// TODO Auto-generated method stub
		int[] index = new int[2 * n + 1];
		for (int i = 1; i < index.length; i++) {
			index[arr[i]] = i;
		}
		return pairs(pairs, arr, index, 2*n,1);
		
	}

		private static int pairs(int[] pairs, int[] arr, int[] index, int n,int i) {
			if(i>n) {
				return 0;
			}
				if(pairs[arr[i]]==arr[i+1]) {
					return	pairs(pairs,arr,index,n,i+2);
				}
				
			int one=arr[i+1];
			int indexone=index[pairs[arr[i]]]; //index [] will give index of values in arr[]---this line give pairs index in arr[]
			int two=arr[index[pairs[arr[i]]]];
			int indextwo=i+1;
			
			arr[i+1]=arr[i+1]^arr[indexone]^(arr[indexone]=arr[i+1]);
			updateValue(index,one,indexone,two,indextwo);
			int a=pairs(pairs,arr,index,n,i+2);
			
			arr[i+1]=arr[i+1]^arr[indexone]^(arr[indexone]=arr[i+1]);
			updateValue(index,one,indextwo,two,indexone);
			
			 two=arr[index[pairs[arr[i+1]]]];
			 indextwo=i;
			arr[i]=arr[i]^arr[indexone]^(arr[indexone]=arr[i]);
			updateValue(index,one,indexone,two,indextwo);
			int b=pairs(pairs,arr,index,n,i+2);
			
			arr[i]=arr[i]^arr[indexone]^(arr[indexone]=arr[i]);
			updateValue(index,one,indextwo,two,indexone);
			return 1+Integer.min(a, b);
				
}

		private static void updateValue(int[] index, int one, int indexone, int two, int indextwo) {			
				index[indexone]=one;
				index[indextwo]=two;			
			
		}
		
		
		
		
}
