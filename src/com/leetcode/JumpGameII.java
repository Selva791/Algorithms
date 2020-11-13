package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {
	public static void main(String[] args) {
		JumpGameII jp = new JumpGameII();
		int nums[] = { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
		// {2,1};
		// {2,3,1,1,4};
		System.out.println(jp.jump(nums));
	}

	class Jumper {
		int value;
		int jump;

		Jumper(int value, int jump) {
			this.value = value;
			this.jump = jump;
		}
	}

	public int jump(int[] nums) {

		int n = nums.length;
		if (n == 1)
			return 0;
		else if (nums[0] >= n - 1) {
			return 1;
		}
		Queue<Jumper> q = new LinkedList<>();

		boolean visit[] = new boolean[n];

		visit[0] = true;

		q.add(new Jumper(0, 0));// Initial position(index ,jump count)

		while (!q.isEmpty()) {
			Jumper s = q.poll();
			int index = s.value;
			int t = s.jump;
			if (nums[index] + index >= n - 1) { //to check whether we reached last index
				return s.jump + 1;		//added one bcs we return total count before last one jump
			}

			int count = nums[index];	
			int i = index + count; // i set to last position and decremented iteratively
			
			// Adding values from last so that ,we can reach last index easily, while polling from queue
			while (i >= index && i < n) {		
				if (!visit[i]) {			//un visited nodes only allowed
					visit[i] = true;
					q.add(new Jumper(i, t + 1));	//t+1 for each jump

				}
				i--;
				count--;

			}

		}
		return 0;
	}
}
