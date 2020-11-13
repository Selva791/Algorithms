package com.hacker;
//https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
//this also can be solved using queues but here i used backtracking
//IDEA: two recursive call inside function can traverse whole matrix

public class RateInMaze {
	static int N;
	private void solveMaze(int[][] maze) {
		// TODO Auto-generated method stub
		int sol [][]=new int [N][N];
		if(solveMaze(maze,0,0, sol)) {
			printer(sol);
			System.out.println("Reached");
		}
	}
private void printer(int[][] sol) {
		// TODO Auto-generated method stub
	for (int i = 0; i < N; i++) { 
        for (int j = 0; j < N; j++) 
            System.out.print(" " + sol[i][j] + " "); 
        System.out.println(); 
    } 
	}
private boolean solveMaze(int[][] maze, int i, int j,int sol[][]) {

		// TODO Auto-generated method stub
	if(i==N-1&&j==N-1&&maze[i][j]==1) {
		sol[i][j]=1;
		return true;
	}

	if(isSafetoCall(i,j,maze)==true) {
		System.out.println(i+" "+j);
		sol[i][j]=1;

	//	System.out.println(i+" "+j);
		if(solveMaze(maze,i+1,j,sol))
		return true;
		
		//System.out.println(i+" "+j);

		if(solveMaze(maze,i,j+1,sol))
		return true;
		
		sol[i][j]=0;

		return false;
	}
	return false;
		
	}
private boolean isSafetoCall(int i, int j, int[][] maze) {
	// TODO Auto-generated method stub
	if(i>=0&&j>=0&&i<N&&j<N&&maze[i][j]==1) {
		return true;
		
	}
	return false;
}
public static void main(String[] args) {
	RateInMaze rat = new RateInMaze(); 
    int maze[][] = { { 1, 0, 0, 0 }, 
                     { 1, 1, 0, 1 }, 
                     { 0, 1, 1, 1}, 
                     { 1, 1, 0, 1 } }; 

    N = maze.length; 
    rat.solveMaze(maze);
}


}
