package com.leetcode;

import java.util.Arrays;

public class FriendCirclesUnionFind {
	public static void main(String[] args) {
		int m[][]= {{0,0,0},
		             {0,0,0},
		             {0,0,1}};
		FriendCirclesUnionFind f=new FriendCirclesUnionFind();
		f.findCircleNum(m);
	}
	 public int findCircleNum(int[][] M) {
	        int rows = M.length;
	        int cols = M[0].length;
	        
	        
	        int[] dsu = new int[rows];
	        Arrays.fill(dsu, -1);
	        
	        for(int i = 0; i < rows; i++) {
	            for(int j = 0; j < cols; j++) {
	                if(i == j) continue;
	                if(M[i][j] == 0) continue;
	                
	                int p1 = find(dsu, i);
	                int p2 = find(dsu, j);
	                
	                if(p1 == p2) continue;
	                
	                union(dsu, p1, p2);
	            }
	        }
	        
	        int circles = 0;
	        
	        for(int i : dsu) if(i < 0) circles++;
	        
	        return circles;
	    }
	    
	    
	    private int find(int[] dsu, int i) {
	        if(dsu[i] < 0) return i;
	        
	        return find(dsu, dsu[i]);
	    }
	    
	    private void union(int[] dsu, int p1, int p2) {
	        if(dsu[p1] <= dsu[p2]) {
	            dsu[p1] += dsu[p2];
	            dsu[p2] = p1;
	            return;
	        }
	        
	        dsu[p2] += dsu[p1];
	        dsu[p1] = p2;
	    }
}
