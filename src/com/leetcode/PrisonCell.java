package com.leetcode;

public class PrisonCell {
	public static void main(String[] args) {
		PrisonCell p = new PrisonCell();
		int cells[] = { 1, 0, 0, 1, 0, 0, 1, 0 };
		// {1,0,0,1,0,0,1,0};
		// [0, 1, 1, 0, 0, 0, 0, 0]
        StringBuilder temp=new StringBuilder();

		System.out.println(p.prisonAfterNDays(cells, 1000000000));
		System.out.println();
	}

	public int[] prisonAfterNDays(int[] cells, int N) {
		N = N % 14 == 0 ? 14 : N % 14;

		for (int i = 0; i < N; i++) {
			int prev = 0;
			int next = 0;
			int index = 0;

			while (index < 7) {
				if (index == 0) {
					prev = cells[index];
					cells[index] = 0;
				} else if (prev == cells[index+1]) {
					prev=cells[index];
					cells[index]=1;
					
				} else {
					prev=cells[index];

					cells[index]=0;

				}
				if(index==cells.length-2) {
					cells[cells.length-1]=0;
				}
				index+=1;

			}

		}
		return cells;
	}
}
