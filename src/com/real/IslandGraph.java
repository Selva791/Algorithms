package com.real;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//own waste solution :D
public class IslandGraph {

	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
								  { 0, 1, 0, 0, 1 },
								  { 1, 0, 0, 1, 1 },
								  { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		IslandGraph I = new IslandGraph();
		System.out.println("Number of islands is: " + I.countIslands(M));

	}

	private int countIslands(int[][] m) {
		int[] s1 = new int[] { -1, 1, 1, -1, 0, -1, 1, 0 };
		int[] s2 = new int[] { 1, -1, 0, 0, 1, -1, 1, -1 };
		List<Integer> li=new ArrayList<Integer>();
		class value {
			int ad1, ad2;

			value(int val1, int val2) {
				ad1 = val1;
				ad2 = val2;
			}
		}
		int no=1;
		boolean visited[][] = new boolean[m.length][m.length];
		Queue<value> q = new LinkedList<>();
		//q.add(new value(0, 0));
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				
				if(visited[i][j]==false&&m[i][j]==1) {
					visited[i][j]=true;
					q.add(new value(i, j));
					no=1;
				while (!q.isEmpty()) {
					value v = q.poll();
					
					int x = 0, y = 0;
					for (int k = 0;k < s1.length; k++) {
						x = s1[k];
						y = s2[k];

						int x1 = v.ad1 + x;
						int y1 = v.ad2 + y;
						if (isSafe(x1, y1, m) && visited[x1][y1] == false) {
							x=x1;
							y=y1;
							visited[x][y] = true;


							if (m[x][y] == 1) {
								q.add(new value(x,y));

								no++;
							}
						}
					}
				}
				System.out.println(no);
				li.add(no);
				
				}
			}
			
		}
	

		return li.size();
	}

	private boolean isSafe(int x, int y, int[][] m) {
		// TODO Auto-generated method stub
		if (x>=0&&m.length >x &&y>=0&& m.length > y) {
			return true;
		}
		return false;
	}
}
