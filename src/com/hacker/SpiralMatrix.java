package com.hacker;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			//{{2,3}};
			//{{2,3}};
			//{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		//	{ { 7 }, { 9 }, { 6 } };
		/*
											 * { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
											 */
		// { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		/*
		 * { { 1, 2, 3, 6, 7, 8 }, { 15, 5, 6, 5, 3, 1 }, { 13, 8, 9, 3, 1, 8 }, { 12,
		 * 2, 3, 6, 7, 8 }, { 1, 2, 3, 6, 7, 8 }
		 */

		SpiralMatrix mt = new SpiralMatrix();
		System.out.println(mt.spiralOrder(m));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		int row = matrix.length-1;

		int coloumn = row==-1 ?-1:matrix[0].length-1;
		List<Integer> spiral = new ArrayList<>();
		int r = 0;
		int o = 0;
		int c = 0;

		while (c<=coloumn&&coloumn >=0&& row >= 0&&r<=row) {

			for (int n = r; n<= coloumn; n++) {
				spiral.add(matrix[r][n]);
			}
			r++;

			for (int n = r; n<= row; n++) {
				spiral.add(matrix[n][coloumn]);
			}
			
			for (int n = coloumn - 1; n >=o; n--) {
				if(o<row) {
				spiral.add(matrix[row][n]);
				}
			}
			o++;
		
			for (int n = row - 1; n >=r; n--) {
				if(c<coloumn) {
				spiral.add(matrix[n][c]);
				}
			}
			c++;
			coloumn--;
			row--;
		}

		return spiral;
	}
}
