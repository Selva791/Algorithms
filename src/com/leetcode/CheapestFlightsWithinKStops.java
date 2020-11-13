package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {
public static void main(String[] args) {
	int s[][]= {{0,1,100},{1,2,100},{0,2,500}};
	CheapestFlightsWithinKStops c=new CheapestFlightsWithinKStops();
	System.out.println(c.findCheapestPrice(3, s, 0, 2, 1));
}
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int grid[][]=new int [n][n];
       for(int s[]:flights){
           grid[s[0]][s[1]]=s[2];
            
       }
       Arrays.asList(6,8,9).sort((a,b)->a-b);;
       PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
       pq.offer(new int[]{0,src,k+1});
       
       while(!pq.isEmpty()){
           int cur[]=pq.poll();
           
           int price=cur[0];
           int place=cur[1];
           int stop=cur[2];
           if(place==dst){
               return price;
           }
          if(stop>0){
           for(int i=0;i<n;i++){
               if(grid[place][i]>0)
               pq.offer(new int[]{grid[place][i]+price,i,stop-1});
               
               
           }
          }
       }
       return -1;
   }
}
