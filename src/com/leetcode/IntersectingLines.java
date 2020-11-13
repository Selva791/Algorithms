package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/interval-list-intersections/discuss/647582/java-Easy-Solution
public class IntersectingLines {
	public static void main(String[] args) {
	//	{{4,6],{7,8},{10,17}}
	//			{{5,10}}	
		int A[][] ={{4,6},{7,8},{10,17}};//{{3,5},{9,20}};//{{8,15}}; //{{0,2},{5,10},{13,23},{24,25}};
		int B[][]= {{5,10}};//{{4,5},{7,10},{11,12},{14,15},{16,20}};//{{2,6},{8,10},{12,20}};//{{1,5},{8,12},{15,24},{25,26}};
		IntersectingLines in=new IntersectingLines();
		in.intervalIntersection(A, B);
		in.intervalIntersections(A, B);

	}
	public int[][] intervalIntersections(int[][] A, int[][] B) {
		List<int[]> list=new ArrayList<>();
		int c=0;
		int x=0;
		int p=0;
		while(x<A.length&&p<B.length) {
			if(A[x][0]>B[p][0]&&A[x][0]>B[p][1]) { //checks disjoint condition
				if(A[x][1]<B[p][1])
					x++;
					else 
					p++;
		}else if(B[p][0]>A[x][0]&&B[p][0]>A[x][1]) {//checks disjoint condition
			if(A[x][1]<B[p][1])
				x++;
				else 
				p++;
		}else {
			//When there is an intersection, we can add the intersection points
			int m=Math.max(A[x][0], B[p][0]);
			
			int n=Math.min(A[x][1], B[p][1]);
			list.add(new int[]{m,n});
			
			if(A[x][1]<B[p][1])//Based on large coordinated value, we can increment the position
				x++;
				else 
				p++;
		}
		}
		int result[][]=new int[list.size()][2];
		int index=0;
		for (int[] is : list) {
			result[index]=is;
			index++;
		}
		return result; 
	}
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> list=new ArrayList<>();
		int c=0;
		int x=0;
		int p=0;
		while(x<A.length&&p<B.length) {
	
			 if(A[x][0]>=B[p][0]&&A[x][0]<B[p][1]&&(A[x][1]>=B[p][1])) {
				if(A[x][1]>=B[p][1]) {
					int v[]= {A[x][0],B[p][1]};
					list.add(v);
					if(A[x][1]<B[p][1])
						x++;
						else 
						p++;
					
				}
				
			}else if(A[x][1]>B[p][0]&&A[x][1]<=B[p][1]&&A[x][0]<=B[p][0]) {
				if(A[x][0]<=B[p][0]) {
					
					int v[]= {B[p][0],A[x][1]};
					list.add(v);
					if(A[x][1]<B[p][1])
					x++;
					else p++;
				}
			}else if(A[x][1]==B[p][0]) {
				int v[]= {B[p][0],A[x][1]};
				
				list.add(v);
				
				x++;	
				
			}else if(A[x][0]==B[p][1]) {
				int v[]= {A[x][0],B[p][1]};
				
				list.add(v);
					p++;
			}else {
				
				
				
				if((A[x][0]<B[p][0]&&A[x][1]>B[p][1])||(A[x][0]>B[p][0]&&A[x][1]<B[p][1])) {
					if(A[x][0]<B[p][0]&&A[x][1]>B[p][1]) {
						int v[]= {B[p][0],B[p][1]};
						list.add(v);
					
							p++;
					}else if(A[x][0]>B[p][0]&&A[x][1]<B[p][1]) {
						int v[]= {A[x][0],A[x][1]};
						list.add(v);
					
							x++;
					}
					
				}else {
					if(A[x][1]<B[p][1])
					x++;
					else p++;
				}
			}
			
		}
		int result[][]=new int[list.size()][2];
		int index=0;
		for (int[] is : list) {
			result[index]=is;
			index++;
		}
		return result; 		
	}
}
