package com.hacker;

import java.util.LinkedList;
import java.util.Queue;

public class RetryKnight {

	public static void main(String[] args) {
		int n = 30;
		int start[] = { 1, 2 };
		int end[] = { 4, 4 };
		int f=process(start, end, n);
		System.out.println(" Final count: "+f);
		

	}

	private static int process(int[] start, int[] end, int n) {
		int d1[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int d2[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
		Boolean[][] visited = new Boolean[n+1][n+1];
		for (int i = 0; i <=n; i++) {
			for (int j = 0; j <=n; j++) {
				visited[i][j] = false;
			}
		}
		int x,y;
		Queue<cell> q = new LinkedList<>();
		visited[start[0]][start[1]]=true;
		
		q.add(new cell(start[0], start[1], 0));
		while (!q.isEmpty()) {
			cell c = q.poll();
			if (c.a == end[0] && c.b == end[1]) {
				return c.c;
			}
			for (int r = 0; r < 8; r++) {
				x = c.a + d1[r];
				y = c.b + d2[r];
				
				if(isInside(y,x,n)&&!visited[x][y]) {
					visited[x][y]=true;
					
					q.add(new cell(x,y,c.c+1));
					
				}

			}
			
		}
		 
		
		return -1;
      
	}

	private static boolean isInside(int a,int b,int n) {
		if(a>=1&&b>=1&&a<=n&&b<=n) {
			return true;
		}
		return false;
	}

}

class cell {
	int a, b, c;

	cell(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
