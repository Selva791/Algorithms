package com.leetcode;

import java.util.Arrays;

public class FloodFill {
	public static void main(String[] args) {
		FloodFill f=new FloodFill();
	
		int image[][]= {{0,0,0},{0,1,0}};
		f.floodFill(image, 1, 1, 2);
		
	}
	  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        boolean visited[][]=new boolean [image.length][image[0].length];
	       // visited[sr][sc]=true;
	   arr= new int [image.length][image[0].length];
	   for(int i=0;i<image.length;i++) {
		   arr[i]=Arrays.copyOf(image[i], image[0].length);
	   }
	   arr[sr][sc]=newColor;
	   visited[sr][sc]=true;
	                filler(image,sr,sc,newColor,visited);
	                return arr;

	    }
	            int arr[][];

	    public void filler(int[][] image, int sr, int sc, int newColor,boolean[][]visited){
	               int data= image[sr][sc];
	        int x[]={-1,0,0,1};
	        int y[]={ 0,-1,1,0};
	         for(int i=0;i<4;i++){
	        	
	             sr=sr+x[i];
	             sc=sc+y[i];
	            
	             if(isSafe(sr,sc,image)&&(visited[sr][sc]==false) && data==image[sr][sc]){
	                 arr[sr][sc]=newColor;
	                 visited[sr][sc]=true;
	             filler(image,sr,sc,newColor,visited);
	             sr=sr-x[i];
	             sc=sc-y[i];
	             }else {
	            	 sr=sr-x[i];
		             sc=sc-y[i];
	             }
	        }
	    }
	    boolean isSafe(int r,int c,int [][]image){
	        if(r>=0&&c>=0&&r<image.length&&c<image[0].length){
	            return true;
	        }
	        return false;
	    }

}
