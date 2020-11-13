package com.leetcode;

import java.util.Stack;

public class AsteroidCollisionOptimised {
	public static void main(String[] args) {
		AsteroidCollisionOptimised a=new AsteroidCollisionOptimised();
		a.asteroidCollision(new int [] {5,10,-5});
	}

	public int[] asteroidCollision(int[] asteroids) {
		int n = asteroids.length;
		if (n == 0)
			return asteroids;
		Stack<Integer> res = new Stack<>();

		for (int i = 0; i < n; i++) {
			int temp = asteroids[i];
			if (temp > 0 || res.isEmpty()) {
				res.push(temp);
				continue;
			}
			while (true) {

				int prev = res.peek();
				if (prev < 0) {
					res.push(temp);
					break;
				}
				if (prev < -temp) {
					res.pop();
				} else if (prev == -temp) {
					res.pop();

					break;
				} else {
					break;
				}
				if (res.isEmpty()) {
					res.push(temp);
					break;
				}
			}

		}
		int result[] = new int[res.size()];
		for (int i = res.size() - 1; i >= 0; i--) {
			result[i] = res.pop();
		}
		return result;
	}
}
