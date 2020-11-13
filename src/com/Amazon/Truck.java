package com.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Truck {
	public static void main(String[] args) {
		Truck t=new Truck();
		List<List<Integer>> grid=new ArrayList<List<Integer>>();
		grid.add(Arrays.asList(1,1,0,0));
		grid.add(Arrays.asList(0,0,0,0));
		grid.add(Arrays.asList(0,0,1,1));
		grid.add(Arrays.asList(0,0,0,0));
		System.out.println(t.numberAmazonTreasureTrucks(4, 4, grid));

	}

	class Pop{
		int x;
		int y;
		Pop(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
		int pos[][] = new int[rows][column];
		int p = 0;
		int q = 0;
		for (List<Integer> s : grid) {
			p=0;
			for (int value : s) {
			    if(p<rows){
			        pos[q][p] = value;
			    }
				
				p++;

			}
			if(q<column)
			q++;
		}
		int count=0;
		Queue<Pop> check=new LinkedList<>();
		boolean visited[][]=new boolean[rows][column];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				
				if(pos[i][j]==0) {
					continue;
				}
				if(!visited[i][j]&&pos[i][j]==1) {
					count++;

				
				check.add(new Pop(i,j));
				visited[i][j]=true;
				
				while(!check.isEmpty()) {
					Pop v=check.poll();
					int x[]= {0,1,0,-1};
					int y[]= {1,0,-1,0};
					//Checking adjacent sides
					for(int k=0;k<4;k++) {
						int a=v.x+x[k];
						int b=v.y+y[k];
						if(isSafe(a,b,rows,column)&&pos[a][b]==1&&!visited[a][b]) {
							visited[a][b]=true;
						  check.add(new Pop(a,b));
							
						}
						
						
					}
					
					
				}
			}
				
			}
		}
		
		return count;

	}
	//Check possibility
	private boolean isSafe(int a, int b, int rows, int column) {
		if(a>=0&&a<rows&&b>=0&&b<column) {
			return true;
			
		}
		return false;
	}
	}
