package com.hacker;

public class BallExchange {
	public static void main(String[] args) {
		int[][] container = new int[3][3];
		int f = 0;
		/*
		 * for (int i = 0; i < container.length; i++) { for (int j = 0; j <
		 * container.length; j++) { container[i][j]=f; f++; } }
		 */
		container[0][0] = 0;
		container[0][1] = 2;
		container[0][2] = 1;

		container[1][1] = 1;
		container[1][0] = 1;
		container[1][1] = 1;

		container[2][0] = 2;
		container[2][2] = 0;
		container[2][1] = 0;
		arganize(container);

	}

	private static String arganize(int[][] container) {

		int l = container.length;
		for (int i = 0; i < container.length; i++) {
			for (int j = 0; j < container.length; j++) {
				if (container[j][i] == 1) {
					container[j][i] = 0;
					for (int k = 0; k < container.length; k++) {
						if (container[k][i] > 0) {
							container[k][i]++;
						}
					}
					if (i < container.length - 2) {
						i++;

						for (int j2 = container.length - 1; j2 >= 0; j2--) {
							if (container[j2][i] == 1) {
								container[j2][i] = 0;
								for (int j3 = container.length - 1; j3 >= 0; j3--) {
									if (container[j3][i] > 0) {
										container[j3][i]++;

									}
								}

							}
						}
					}
				}
			}
		}
		String s = "possible";

		for (int i = 0; i < container.length; i++) {
			int h = 0;
			for (int j = 0; j < container.length; j++) {
				if (container[i][j] > 1) {
					h++;
					if (h > 1) {
						s = "Impossible";
					}
				}
			}
			if (h == 0) {
				s = "Impossible";
			}

		}

		return s;
	}

}
