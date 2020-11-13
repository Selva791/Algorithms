package com.Amazon;

import java.util.ArrayList;
import java.util.List;

public class ActivityCell {
	public static void main(String[] args) {
		ActivityCell a=new ActivityCell();
		int [] states= {1,1,1,0,1,1,1,1};
		a.cellCompete(states, 2);
		String s=""+5;
		
	}

	public List<Integer> cellCompete(int[] states, int days) {
		List<Integer> result = new ArrayList<>();
		int n = states.length;
		if (states.length != 8 || days < 1) {
			return result;
		}
		int nextValue = 0;
		int previousValue = 0;
		int index = 0;
		for (int i = 0; i < days; i++) {
			while (index < n) {

				if (index < n) {
					nextValue = states[index + 1];
				} else if (index == n - 1) {
					nextValue = 0;
				}

				// if nextValue is same as previousValue
				if (nextValue == previousValue) {
					// save the current index value for next iteration of loop
					previousValue = states[index];
					// set current index value
					states[index] = 0;
				} else {
					// save the current index value for next iteration of loop
					previousValue = states[index];
					// set current index value
					states[index] = 1;
				}

				// next item in the loop
				index++;
			}
		}
		for (int i = 0; i < n; i++) {
			result.add(states[i]);

		}
		return result;
	}
}
