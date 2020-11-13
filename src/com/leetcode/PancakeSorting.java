package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
	public static void main(String[] args) {
		PancakeSorting p=new PancakeSorting();
		int A[]= {3,2,4,1};
		p.pancakeSort(A);
	}

	  public List<Integer> pancakeSort(int[] A) {
	        List<Integer> result=new ArrayList<>();
	        int n=A.length;
	        for(int i=n-1;i>=0;i--){
	            int index=finder(A,i);
	            reverse(A,index);
	            reverse(A,i);
	            result.add(index);
	            result.add(i+1);
	            
	        }
	        return result;
	    }
	    public void reverse(int A[],int j){
	          int i=0;
	            while(i<j){
	                int temp=A[i];
	                A[i]=A[j];
	                A[j]=temp;
	                i++;
	                j--;
	            }
	        
	        
	    }
	    public int finder(int A[],int n){
	        for(int i=0;i<A.length;i++){
	            if(A[i]==n+1){
	                return i;
	            }
	        }
	        return -1;
	    }
	    
}
