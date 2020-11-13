package com.leetcode;

public class DistributeCandiesToPeople {
	public static void main(String[] args) {
		DistributeCandiesToPeople d=new DistributeCandiesToPeople();
		d.distributeCandies(10, 3);
	}
	public int[] distributeCandies(int candies, int num_people) {

		int c = 0;
		int result[] = new int[num_people];
		int i = 1;

		for (; candies>0;) {
			c = 0;
			while (c < num_people) {
				if (candies > i) {
					result[c++] += i;
					candies = candies - i;
					i++;
				} else {
					result[c++] += candies;
					candies=0;
				}

			}
		}

		return result;
	}
}
