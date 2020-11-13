package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
	public static void main(String[] args) {
		int trips[][]= {{7,5,7},{8,1,9},{10,2,6},{4,7,8},{2,1,3}};
		int n=26;
		CarPooling c=new CarPooling();
		c.carPooling(trips, n);
	}
	public boolean carPooling(int[][] trips, int capacity) {
        int n=trips.length;
        
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        int total=trips[0][0];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{trips[0][0],trips[0][1],trips[0][2]});
        for(int i=1;i<n;i++){
            int t1[]=trips[i-1];
            int t2[]=trips[i];
            while(!pq.isEmpty()&&(pq.peek()[2]<=t2[1]||pq.peek()[1]>=t2[2])){
                int c[]=pq.poll();
                total-=c[0];
            }
            
                pq.add(new int[]{t2[0],t2[1],t2[2]});
                total+=t2[0];
                if(total>capacity)return false;
                
            
        }
        return true;
    }
}
