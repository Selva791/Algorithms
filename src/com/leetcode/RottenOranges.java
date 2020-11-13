package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
public static void main(String[] args) {
	int in[][]= {
			{2,1,1},
			{1,1,0},
			{0,1,1}};
	RottenOranges r=new RottenOranges();
	System.out.println(r.orangesRotting(in));
}
class Rotten{
    int x;
    int y;
    int minutes;
    
    Rotten(int x,int y ,int minutes){
        this.x=x;
        this.y=y;
        this.minutes=minutes;
        
    }
}
public int orangesRotting(int[][] grid) {
      if(grid.length==0){
        return 0;
    }
    if(grid.length==1&&grid[0].length==1){
        if(grid[0][0]==0){
            return 0;
      
        }
    }
  
    int m=grid.length;
    int n=grid[0].length;
   Queue<Rotten> q=new LinkedList<>();
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==2){
            q.add(new Rotten(i,j,0));

            }   
        }
            
    }
  
    int value=0;
    boolean visited[][]=new boolean[m][n]; //to avoid revisiting node
        while(!q.isEmpty()){
            Rotten r=q.poll();
            
            if(value<=r.minutes)
            value=r.minutes;
            
            int xd[]={0,-1,0,1};
            int yd[]={-1,0,1,0};
            
            for(int i=0;i<4;i++){
                int k=xd[i]+r.x;
                int t=yd[i]+r.y;
                if(isSafe(k,t,grid)&&visited[k][t]==false){
                visited[k][t]=true;

                    if(grid[k][t]==1){
                        grid[k][t]=2;
                        q.add(new Rotten(k,t,r.minutes+1));
                    }
                    
                }
                
            }
            
        }
    //Final check
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
        	//If any value in grid is equals 1 then return -1
            if(grid[i][j]==1){
                return -1;
                
            }
            
        }
    }
    return value;
    
}
public boolean isSafe(int x,int y,int g[][]){
    if(x>=0&&y>=0&&x<g.length&&y<g[0].length){
        return true;
    }
    return false;
}
}
