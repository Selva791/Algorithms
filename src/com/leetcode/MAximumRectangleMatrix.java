package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MAximumRectangleMatrix {
	public static void main(String[] args) {
		MAximumRectangleMatrix m = new MAximumRectangleMatrix();
		char matrix[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
String s="ADVDVBD";
s.replace(s.charAt(0)+"","");
		System.out.println(m.maximalRectangle(matrix));
	}

	public int maxArea(int[] hist) {
		Stack<Integer> st = new Stack<>();
		int area = 0;
		int maxarea = -1;
		int i=0;
		for ( i = 0; i < hist.length;) {
			if (st.isEmpty() || hist[st.peek()] < hist[i]) {
				st.push(i++);
			} else {
				int top = st.pop();
				if (st.isEmpty()) {
					area = hist[top] * i;
				} else {
					area = hist[top] * (i - st.peek() - 1);
				}

			}
			if (maxarea < area) {
				maxarea = area;
			}

		}
		//int i = 0;
		while (!st.isEmpty()) {

			int top = st.pop();
			if (st.isEmpty()) {
				area = hist[top] * i;
			} else {
				area = hist[top] * (i - st.peek() - 1);
			}

			if (maxarea <area) {
				maxarea = area;
			}
		}
		return maxarea;
	}

	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0) {
			return 0;
		}
		int hist[] = new int[matrix[0].length];
		int value = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (matrix[i][j] == '0') {
					hist[j] = 0;
				} else {
					hist[j] += Character.getNumericValue(matrix[i][j]);
				}
			}
			int k = maxArea(hist);
			value = k > value ? k : value;
		}
		return value;
	}

}
