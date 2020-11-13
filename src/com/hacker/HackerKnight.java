package com.hacker;

import java.util.Vector;

import com.hacker.KnightSteps.cell;

public class HackerKnight {
		static class cell  
		{  
		    int x, y;  
		    int dis;  
		  
		        public cell(int x, int y, int dis) 
		        { 
		            this.x = x; 
		            this.y = y; 
		            this.dis = dis; 
		        } 
		      
		      
		} 
	
public static void main(String[] args) {
	int N = 5;  
    int knightPos[] = {0,0};  
    int targetPos[] = {N-1, N-1}; 
    int g[][]=new int[N-1][N-1];
    int mat[][]=new int[N-1][N-1];
    int l=0;
    int k=0;
    for (int i = 1; i <N; i++) {
    	for (int j = 1; j <N; j++) {
    		
         g[l][k]= minStepToReachTarget(knightPos, targetPos, N,i,j); 
         k++;
		}
    	l++;
    	k=0;
		System.out.println();
	}
 
}



private static int minStepToReachTarget(int[] knightPos, int[] targetPos, int N,int p,int s) {
	// TODO Auto-generated method stub
	  
    // x and y direction, where a knight can move  
    int dx[] = {-s, -p, p, s, -s, -p, p, s};  
    int dy[] = {-p, -s, -s, -p, p, s, s, p};  
  
    // queue for storing states of knight in board  
    Vector<cell> q = new Vector<>();  
  
    // push starting position of knight with 0 distance  
    q.add(new cell(knightPos[0], knightPos[1], 0));  
  
    cell t ;  
    int x, y;  
    boolean visit[][] = new boolean[N+1][N+1];  
  
    // make all cell unvisited  
    for (int i = 1; i <= N; i++)  
        for (int j = 1; j <= N; j++)  
            visit[i][j] = false;  
  
    // visit starting state  
    visit[knightPos[0]][knightPos[1]] = true;  
  
    // loop untill we have one element in queue  
    while (!q.isEmpty())  
    { 
        t  = q.firstElement();  
        q.remove(0);  
  
        // if current cell is equal to target cell,  
        // return its distance  
        if (t.x == targetPos[0] && t.y == targetPos[1])  
            return t.dis;  
  
        // loop for all reachable states  
        for (int i = 0; i < 8; i++)  
        {  
            x = t.x + dx[i];  
            y = t.y + dy[i];  
  
            // If reachable state is not yet visited and  
            // inside board, push that state into queue  
            if (isInside(x, y, N) && !visit[x][y]) 
            {  
                visit[x][y] = true;  
                q.add(new cell(x, y, t.dis + 1));  
            }  
        }  
    }  
        return -1; 

	
}
static boolean isInside(int x, int y, int N)  
{  
    if (x >= 0 && x < N && y >= 0 && y < N)  
        return true;  
    return false;  
} 

}
