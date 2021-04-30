package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingPuzzle {
	
	public static void main(String[] args) {
		SlidingPuzzle s=new SlidingPuzzle();
		int [][]board={{1,2,3},{5,4,0}};
		//int [][]board2= {{4,1,2},{5,0,3}};
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		for(int a:pq) {
			
		}
		
		System.out.println(s.slidingPuzzle(board));
	}

	class Puzzle {
		int[][] bd;
		int x, y, s;

		Puzzle(int[][] bd, int x, int y, int s) {
			this.bd = bd;
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}

	int target[][]={{1,2,3},{4,5,0}};
	 List<int[][]> st;
	public int slidingPuzzle(int[][] board) {
		        int n=2,m=3;
		        
		        st=new ArrayList<>();
		        int x=-1 ,y=-1;
		        boolean flag=false;
		        for(int i=0;i<n;i++){
		            for(int j=0;j<m;j++){
		                if(board[i][j]==0){
		                    x=i;
		                    y=j;
		                    flag=true;
		                    break;
		                }
		            }
		            if(flag)break;
		        }
		        boolean visited[][]=new boolean[n][m];
		       return puzzleSolver(x,y,board,visited);
		    }

	public int puzzleSolver(int u, int v, int[][] board, boolean visited[][]) {
		int a[] = { -1, 0, 1, 0 };
		int b[] = { 0, 1, 0, -1 };
		Queue<Puzzle> q = new LinkedList<>();
		q.add(new Puzzle(board, u, v, 0));
		st.add(board);
		while (!q.isEmpty()) {
			Puzzle p = q.poll();
			if (check(p.bd)) {
				return p.s;
			}
			for (int i = 0; i < 4; i++) {
				int c = a[i] + p.x;
				int d = b[i] + p.y;
				if (isSafe(c, d, 2, 3)&&!visited[p.x][p.y]) {
					
					int dest[][] = new int[2][3];
					process(dest, p.bd);
					int temp = dest[c][d];
					dest[c][d] = 0;
					dest[p.x][p.y] = temp;
					if(duplicate(dest)) {
						st.add(dest);
						q.offer(new Puzzle(dest,c, d, p.s + 1));
					}
					
				}
			}
			//visited[p.x][p.y]=true;
		}
		return -1;
	}

	private boolean duplicate(int[][] dest) {
		
		for(int[][]c:st) {
			boolean flag=false;
			for(int i=0;i<2;i++) {
				for(int j=0;j<3;j++) {
					if(c[i][j]!=dest[i][j]) {
						flag=true;
						break;
					}
				}
				
			}
			
			if(!flag) {
				return false;
			}
		}
		return true;
	}

	public boolean check(int board[][]) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != target[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public void process(int dest[][], int bd[][]) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				dest[i][j] = bd[i][j];
			}
		}
	}

	public boolean isSafe(int i, int j, int n, int m) {
		if (i >= 0 && i < n && j >= 0 && j < m) {
			return true;
		}
		return false;
	}
}
