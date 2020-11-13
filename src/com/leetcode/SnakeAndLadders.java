package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadders {
	public static void main(String[] args) {
		SnakeAndLadders sl=new SnakeAndLadders();
		int board[][]= 
				{{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,35,-1,-1,13,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,15,-1,-1,-1,-1}};
		System.out.println(sl.snakesAndLadders(board));
	}

	class Snake {
		int count, x;

		Snake(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}

	public int snakesAndLadders(int[][] board) {
		int n = board.length;

		int m = n * n;
		Queue<Snake> q = new LinkedList<>();
		q.add(new Snake(1, 0));
		
		boolean visited[] = new boolean[m + 1];
		visited[1]=true;
		visited[0]=true;
		while (!q.isEmpty()) {
			Snake t = q.poll();
			if (t.x == m)
				return t.count;
			
			for (int i = 1; i <= 6; i++) {
				int total = t.x + i;
				
				if(total>n*n)continue;
				
				int b = calculate(board, total);
				if (b >0)
					total = b;
				

				if (total <= m&&!visited[total]) {
					visited[total]=true;
					q.add(new Snake(total, t.count + 1));
				}

			}
		}
		return -1;
	}

	public int calculate(int[][] board, int num) {
		int n = board.length;
		int d = (num - 1) / n;
		int row = n - 1 - d;
		int c = (num - 1) % n;
		int col = d % 2 == 0 ? c : n - 1 - c;
		return board[row][col];
	//	Character.to
		//String s="";
		//s.toLowerCase();

	}
}
