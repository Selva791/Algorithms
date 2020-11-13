package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFlood {
	public static void main(String[] args) {
		int rains[]= {1,2,0,0,3,6};
		AvoidFlood af=new AvoidFlood();
		af.avoidFlood(rains);
	}
	private static final int[] EMPTY = new int[0];

	public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        int n = rains.length;
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> noRains = new TreeSet<>();
		
        for (int i = 0; i < n; ++i) {
            if (rains[i] == 0) {
                noRains.add(i);
                ans[i] = 1;
            } else if (rains[i] > 0) {
                if (fullLakes.containsKey(rains[i])) {
					// Since the lake is already full, we need to dry it first before we fill it again else it will result in a flood. 
					// ceiling: Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
                    Integer canDry = noRains.ceiling(fullLakes.get(rains[i]));
                    if (canDry == null) return EMPTY;
                    ans[canDry] = rains[i];
                    noRains.remove(canDry);
                }
                fullLakes.put(rains[i], i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}
