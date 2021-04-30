package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumAreaRectangleII {
	public static void main(String[] args) {
		MaximumAreaRectangleII m = new MaximumAreaRectangleII();
		int arr[]= {1,2};
		
        List<Integer> ans=new ArrayList<>();
        
		int pts[][] = { { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 1 } };
		System.out.println(m.minAreaFreeRect(pts));
	}

	public double minAreaFreeRect(int[][] points) {
		int n = points.length;
		Set<String> st=new HashSet<>();
		for(int pt[]:points) {
			st.add(pt[0]+" "+pt[1]);
		}
		double ans=Integer.MAX_VALUE;
		for (int p[] : points) {
			for (int q[] : points) {
				if(p[0]==q[0]&&p[1]==q[1])continue;
				for (int r[] : points) {
						if(p[0]==r[0]&&p[1]==r[1]&&q[0]==r[0]&&q[1]==r[1]) {
							continue;
						}
						
						if(dist(p,q) + dist(q,r)!=dist(p,r)) {
							continue;
						}
						int x=p[0];
						int y=r[1];
						if(!st.contains(x+" "+y)) {
							continue;
							
						}
						double c=Math.sqrt(dist(p, q))*Math.sqrt(dist(q, r));
						if(Double.compare(c, 0)==0) {
							continue;
						}
						
						ans=Math.min(ans, c);
				}
			}
		}
		return ans;
	}

	private int dist(int[] p, int[] r) {
		return (p[0]-r[0])*(p[0]-r[0])+(p[1]-r[1])*(p[1]-r[1]);
	}
}
