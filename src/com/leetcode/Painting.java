package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Painting {
public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);
	 
     int test = s.nextInt();
     for (int t = 0; t < test; t++) {
		
	
     int build = s.nextInt(); 
     int ptype = s.nextInt();
     int sp = s.nextInt(); 
     int num[]=new int[build];
     int cost[][]=new int[build][ptype];
     for(int i=0;i<build;i++) {
    	 num[i]=s.nextInt();
     }

     for (int i = 0; i < build; i++) {
		for (int j = 0; j < ptype; j++) {
			cost[i][j]=s.nextInt();
		}
	}
    System.out.println(findCost(cost,num,build,ptype,sp));
     
     }
}

private static int findCost(int[][] cost, int[] num, int build, int ptype, int sp) {
	// TODO Auto-generated method stub
	Map<Integer, List<Integer>> mp=new HashMap<>();
	List<Integer> index=new ArrayList<Integer>();
	int splitIndex[]=new int[num.length];
	for (int i = 0; i < num.length; i++) {
		if(num[i]==0) {
			index.add(i);
			
		}
	}
	mp.put(0, index);

	int maxSplit=0;
	for (int i = 0; i < num.length; i++) {
		if(i>0&&num[i]==num[i-1]) {
		}else if(i>0) {
			splitIndex[i]=1;
			maxSplit++;
		}
	}
	int total=0;
	if(maxSplit>sp) {
		for (int i = 0; i < num.length; i++) {
			if(num[i]==0&&i>0) {
				int m=num[i-1]-1;
				int n=num[i+1]-1;
				
				if(m>=0&&n>=0&&cost[i-1][m]>cost[i+1][n]) {
					maxSplit--;
					total=total+cost[i+1][n];
					
				}else if(m>=0&&n>0&&cost[i-1][m]<cost[i+1][n]) {
					total=total+cost[i-1][m];

				}else if(m<0&&n==0) {
					int temp=cost[i-1][m];
					for(int j=i;j<num.length;j++) {
						if(num[j]>0&&num[j-1]==0) {
							int c=j-i;
							if(temp>num[j]) {
								while(c>=0) {
									total=total+num[j];
									c--;
								}
							}else {
								
								while(c>=0) {
									total=total+temp;
									c--;
								}
							}
						}
					}
				}
			}else if(num[i]==0&&i==0) {
				for (int j = i; j < num.length; j++) {
					if(num[j]>0) {
						int c=j-1;
						while(c>=0) {
							total=total+num[j];
							c--;
						}
					}
				}
				
			}
		}
		
	}else {
		for (int i = 0; i < num.length; i++) {
			if(num[i]==0&&i>0) {
				int m=num[i-1]-1;
				int n=num[i+1]-1;
				
				if(m>0&&n>0&&cost[i-1][m]>cost[i+1][n]) {
					maxSplit--;
					total=total+cost[i+1][n];
					
				}
				}
			
	}
	}
	return total;
	
	
}
}
