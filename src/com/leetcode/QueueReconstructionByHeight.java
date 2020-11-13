package com.leetcode;

import java.util.Arrays;

public class QueueReconstructionByHeight {
	public static void main(String[] args) {
		int a[][]= {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		QueueReconstructionByHeight q=new QueueReconstructionByHeight();
		System.out.println(q.reconstructQueue(a))
		;
	}
	  public int[][] reconstructQueue(int[][] people) {
	         
	        int n=people.length;
	        if(n==0)return new int[][]{};
	       Arrays.sort(people,(a,b)->a[0]-b[0]);
	       int result[][]=new int[n][2];
	         for(int i=0;i<n;i++)
	        Arrays.fill(result[i],-1);
	           
	       for(int i=0;i<n;i++){
	           int count=people[i][1];
	           for(int j=0;j<n;j++){
	               if(count==0 && result[j][0]==-1){
	                   result[j]=people[i];
	                   break;

	               }else if((people[i][0]<=result[j][0])||result[j][0]==-1){
	                   count-=1;
	                   
	               }
	               
	           }
	       }
	       
	       return result;
	        
	    }
}
