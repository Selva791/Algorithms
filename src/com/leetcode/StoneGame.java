package com.leetcode;

public class StoneGame {
	public static void main(String[] args) {
		StoneGame s=new StoneGame();
		int piles[]= {5,3,4,5};
		s.stoneGame(piles);
	}

	public boolean stoneGame(int[] piles) {

		int n = piles.length - 1;
		return helper(piles, n, 0, 0, 0);
	}

	public boolean helper(int[] piles, int n, int index, int alex, int lee) {
		if (n <= 0) {

		}
		if (n == index) {
			if (alex > lee)
				return true;
			else {
				return false;
			}
		}
		int a = 0, b = 0;
		if (index % 2 == 0) {
			if (helper(piles, n, index + 1, alex + piles[index], lee)
					|| helper(piles, n - 1, index, alex + piles[n], lee)) {
				return true;
			}

		} else {
			if (helper(piles, n, index + 1, alex, lee + piles[index]) || helper(piles, n - 1, index, alex, piles[n])) {
				return true;
			}

		}

		return false;
	}
}
