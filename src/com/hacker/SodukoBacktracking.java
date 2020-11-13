package com.hacker;

public class SodukoBacktracking {
	
	private static boolean solveSudoku(int[][] board, int n) {
		// TODO Auto-generated method stub
		int row=-1;
		int col=-1;
		boolean isEmpty=true;
		for (int i = 0; i < board.length; i++) {
			System.out.println();
			for (int j = 0; j < board.length; j++) {
				if(board[i][j]==0) {
					
				row=i;
				col=j;
				isEmpty=false;
				break;
				}
			}
			if(!isEmpty) {
				break;
			}
		}
		
		
		if(isEmpty){
			return true;
		}
		
		for (int i = 1; i <= board.length; i++) {
			if(isSafe(board,row,col,i)) {
				board[row][col]=i;
				if(solveSudoku(board,n)) {
						return true;
				}else {
					board[row][col]=0;
				}
				
			}
			
			
		}
		return false; 
	}

	private static boolean isSafe(int[][] board, int row, int col, int num) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			if(board[row][i]==num) {
				return false;
			}
		}
		for (int i = 0; i < board.length; i++) {
			if(board[i][col]==num) {
				return false;
			}
		}
		
		int sqrt=(int) Math.sqrt(board.length);
		int boardRow=row-(row % sqrt);
		int boardCol=col-(col % sqrt);
		
		for (int i = boardRow; i <boardRow+sqrt; i++) {
			for (int j = boardCol; j < boardCol+sqrt; j++) {
				if(board[i][j]==num)
					return false;
			}
		}
		return true;
	}

	private static void print(int[][] board, int n) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(" "+board[i][j]+" ");
				
			}
			System.out.println();
		}
		
	}

public static void main(String[] args) {
	

	 int[][] board = new int[][] 
			    { 
			            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
			            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
			            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
			            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
			            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
			            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
			            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
			            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
			    }; 
			    int N = board.length; 
			  
			    if (solveSudoku(board, N)) 
			    { 
			        print(board, N); // print solution 
			    }  
			    else
			    {       print(board, N); // print solution 

			        System.out.println("No solution"); 
			    } 
			
}


}
