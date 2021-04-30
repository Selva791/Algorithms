package com.leetcode;

public class MergeSort {
	public static void main(String[] args) {
		int arr[]= {4,6,3,1,5,7,2};
		MergeSort m=new MergeSort();
		m.mergeSorter(arr,0,arr.length-1);
	}
	public void mergeSorter(int arr[],int low,int high) {
		if(low>=high) {
			return;
		}
		int mid=low+(high-low)/2;
		
		mergeSorter(arr,low,mid);
		mergeSorter(arr,mid+1,high);
		merge(arr,low,mid,mid+1,high);
	}
	public void merge(int arr[],int ls,int le,int rs, int re) {
		int temp[]=new int[re-ls+1];
		int start=ls;
		int end=re;
		int p=0;
		while(ls<=le&&rs<=re) {
			if(arr[ls]>arr[rs]) {
				temp[p++]=arr[rs++];
			}else {
				temp[p++]=arr[ls++];
			}
		}
		while(ls<=le) {
			temp[p++]=arr[ls++];
		}
		while(rs<=re) {
			temp[p++]=arr[rs++];
		}
		int i=0;
		while(i<temp.length) {
			arr[start++]=temp[i++];
		}
	}
}



