package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
	public static void main(String[] args) {
		int A[][]= {{0,1,0,0,0,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{1,1,0,0,0,0}};
			//{{0,1,0},{0,0,0},{0,0,1}}; 
			//{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
		ShortestBridge s=new ShortestBridge();
		System.out.println(s.shortestBridge(A));
		}
	
	class Island {
		int x, y;
		int count;

		Island(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public boolean isSafe(int x, int y, int n, int m) {
		if (x >= 0 && x < n && y >= 0 && y < m)
			return true;

		return false;

	}

	public int shortestBridge(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		if (n == 0) {
			return 0;
		}
		Queue<Island> q = new LinkedList<>();
		boolean visit[][] = new boolean[n][m];

		int cx[] = { -1, 0, 0, 1 };
		int cy[] = { 0, 1, -1, 0 };
		boolean flag = false;
		boolean connect=false;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				if(A[i][j]==1&&!visit[i][j]&&!flag) {
					flag=true;
					BFS(i,j,A,visit,q);
					break;
				}
				
				
			}
			if(flag==true)break;

		}
		
		while (!q.isEmpty()) {
			Island w = q.poll();
			for (int i = 0; i < 4; i++) {
				int s = w.x + cx[i];
				int p = w.y + cy[i];
			
			
				if (isSafe(s, p, n, m) && !visit[s][p]) {
					if(A[s][p] == 1) {
						return w.count;
					}
					visit[s][p] = true;
					if (A[s][p] == 0) {
						q.add(new Island(s, p, w.count + 1));
					} else if(A[s][p] == 1){
						
						q.add(new Island(s, p, w.count));

					}

				}

			}

		}
		return 0;
	}

	private void BFS(int i, int j, int[][] a,boolean visit[][], Queue<Island> q) {
		// TODO Auto-generated method stub
		if(i>=0&&j>=0&&i<a.length&&j<a[0].length&&a[i][j]==1&&!visit[i][j]) {
			q.add(new Island(i, j, 0));
			a[i][j]=2;
			BFS(i+1,j,a,visit,q);
			BFS(i,j+1,a,visit,q);
			BFS(i-1,j,a,visit,q);
			BFS(i,j-1,a,visit,q);

			
		}
		return ;
		
	}
}
