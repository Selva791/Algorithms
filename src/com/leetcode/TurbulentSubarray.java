package com.leetcode;

public class TurbulentSubarray {
	public static void main(String[] args) {
		int t[]= {9,4,2,10,7,8,8,1,9};
		TurbulentSubarray ts=new TurbulentSubarray();
		ts.maxTurbulenceSize(t);
	}

	 public int maxTurbulenceSize(int[] A) {
	        int n=A.length;
	        int count=0;
	        int temp=0;
	        for(int i=0;i<n;i++){
	            if(i+1<n&&i%2==0&&A[i]<A[i+1]){
	                count+=1;
	            }else if(i+1<n&&i%2>0&&A[i]>A[i+1]){
	                count+=1;
	            }else{
	                count=0;
	            }
	            if(count>temp)
	                temp=count;
	        }
	    count=temp+1;
	        int total=0;
	        
	        for(int i=0;i<n;i++){
	            if(i+1<n&&i%2==0&&A[i]>A[i+1]){
	                total+=1;
	            }else if(i+1<n&&i%2>0&&A[i]<A[i+1]){
	                total+=1;
	            }else{
	                total=0;
	                
	            }
	            if(total>temp)
	                temp=total;
	        }
	        total=temp+1;
	        return total>count?total:count;
	    }
}
