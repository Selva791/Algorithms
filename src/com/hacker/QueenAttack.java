package com.hacker;

import java.util.Random;
import java.util.Scanner;

public class QueenAttack {

	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		r_q=r_q-1;
		c_q=c_q-1;
		
		int m = 0, p = 0;
		int board[][] = new int[n][n];
		Random s=new Random();
		for (int i = 0; i < k; i++) {
			board[obstacles[i][0]-1][obstacles[i][1]-1] = -1;
		}
		for (int i = r_q+1; i < n; i++) {
			if(board[i][c_q]!=-1) {
				board[i][c_q]=1;
			}else {
				break;
			}
		}
		for (int i = c_q+1; i < n; i++) {
			if(board[r_q][i]!=-1) {
				board[r_q][i]=1;
				

			}else {
				break;
			}
		}
		for (int i = r_q-1; i >=0 ; i--) {
			if(board[i][c_q]!=-1) {
				board[i][c_q]=1;

			}else {
				break;
			}
		}
		for (int i = c_q-1; i >=0; i--) {
			if(board[r_q][i]!=-1) {
				board[r_q][i]=1;

			}else {
				break;
			}
		}
		int t=c_q;
		for (int i = r_q+1; i < n; i++) {
			t--;
			if(t>=0&&board[i][t]!=-1) {
				board[i][t]=1;

				
			}else {
				
				break;
			}
		}
		int y=c_q;
		for (int i = r_q+1; i < n; i++) {
			y++;
			if(y<n&&board[i][y]!=-1) {
				board[i][y]=1;

			}else {
				break;
			}

		}
		int u=r_q;
		for (int i = c_q+1; i < n; i++) {
			u--;
			if(u>=0&&board[u][i]!=-1) {
				board[u][i]=1;

			}else {
				break;
			}
			
		}
		int r=r_q;
			for (int j = c_q-1; j >=0; j--) {
				r--;
				if(r>=0&&board[r][j]!=-1) {
					board[r][j]=1;

				}else {
					break;
				}
				
				
			}
			int val=countPosition(board);
		return val;
	}

	private static int countPosition(int[][] board) {
		// TODO Auto-generated method stub
		int c=0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j]==1) {
					c++;
				}
				
			}
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] obstacles = new int[0][2];
		//int[][] obstacles = { { 5, 5 }, { 4, 2 }, { 2, 3 } };
		
		// int obs[][]=new int [6][6];

		int s=queensAttack(10000, 0, 4187, 5068, obstacles);
System.out.println(" Values: "+s);
	}
}
