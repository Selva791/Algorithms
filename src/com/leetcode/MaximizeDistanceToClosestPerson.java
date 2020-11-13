package com.leetcode;

import java.util.Stack;

public class MaximizeDistanceToClosestPerson {
	public static void main(String[] args) {
		MaximizeDistanceToClosestPerson m=new MaximizeDistanceToClosestPerson();
		int seats []= {0,1,0,1,0};
		System.out.println(m.maxDistToClosest(seats));
	}
	 public int maxDistToClosest(int[] seats) {

			int n = seats.length;
			Stack<Integer> st=new Stack<>();
			int count=0;
			int cur=0;
			for(int i=0;i<n;i++) {
				if(seats[i]==1) {
				//	count=Math.max(cur, count);
					if(st.isEmpty()) {
						count=Math.max(cur, count);
						st.push(i);
					}else {
						if(cur>1&&cur%2>0) {
							cur=(cur/2)+1;
						}else if(cur%2==0) {
							cur=(cur/2);

						}
						count=Math.max(cur, count);
						st.pop();
						st.push(i);
					}
					cur=0;
				}else if(seats[i]==0) {
					cur+=1;
				}
				
			}
			if(cur>count)return cur;
			
			return count;

		}
	
}
