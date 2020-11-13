package com.hacker;

import java.util.ArrayList;
import java.util.List;

public class QueenAttackKing {
	public static void main(String[] args) {
		int queen[][] = {{7,5},{0,7}};
			//	[5,7]
			//{ { 0, 1 }, { 1, 0 }, { 4, 0 }, { 0, 4 }, { 3, 3 }, { 2, 4 } };

		int[] king = { 5,7 };
		System.out.println(queensAttacktheKing(queen, king));
	}

	public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		List<List<Integer>> attack = new ArrayList<>();
		boolean avail = true;
		boolean visited[][] = new boolean[8][8];
		int x[] = { -1, 0, 1, 0, 1, -1, -1, 1 };
		int y[] = { 0, 1, 1, -1, 0, -1, 1, -1 };
		for (int i = 0; i < 8; i++) {

			int n = x[i];
			int m = y[i];
			int a = king[0];
			int b = king[1];
			for (int j = 0; j < 8; j++) {
					avail=true;
					a = a + n;
					b = b + m;
					if ((isSafe(a, b, 8)) && visited[a][b] == false) {
						visited[a][b] = true;
						for (int v = 0; v < queens.length; v++) {
								if (queens[v][0] == a && queens[v][1] == b) {
									
									List<Integer> inside = new ArrayList<Integer>();
									inside.add(a);
									inside.add(b);
									attack.add(inside);
									avail = false;
									break;
								}
							}
						
					} else {
						avail = false;
						break;
					}
					
				if(!avail) {
					break;
				}
			}
		}
		return attack;

	}

	private static boolean isSafe(int n, int m, int i) {
		// TODO Auto-generated method stub
		if (n >= 0 && m >= 0 && n<8 && m<8) {
			return true;
		}
		return false;
	}
}
