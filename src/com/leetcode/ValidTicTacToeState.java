package com.leetcode;

public class ValidTicTacToeState {
	public static void main(String[] args) {
		ValidTicTacToeState v=new ValidTicTacToeState();
		System.out.println(v.validTicTacToe(new String[] {"OXX","XOX","OXO"}));
	}

	 public boolean validTicTacToe(String[] board) {
			int n = board.length;
			char arr[][] = new char[3][3];
			int t1 = 0, t2 = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					arr[i][j] = board[i].charAt(j);
					if (arr[i][j] == 'X') {
						t1++;
					} else if (arr[i][j] == 'O') {
						t2++;
					}
				}
			}
			if (t2 == 1 && t1 == 0) {
				return false;
			} else if (Math.abs(t1 - t2) > 1) {
				return false;
			} else if (t1 + t2 > 9) {
				return false;
			}

			int r1 = 0, r2 = 0, r3 = 0, c1 = 0;
			for (int i = 0; i < 3; i++) {
				int x = 0, o = 0;
				for (int j = 0; j < 3; j++) {
					if (arr[i][j] == 'X') {
						x++;
					} else if (arr[i][j] == 'O') {
						o++;
					}

				}
				if ((x == 3 || o == 3) && r1 == 0) {
					r1 = 3;
	                if(x==3){
	                   if(t1-t2==1){
	                       return true;
	                   }else return false;
	                }else if(o==3){
	                     if(t1-t2==0){
	                       return true;
	                   }else return false;
	                }
				} else if((x == 3 || o == 3) && r1 ==3){
					return false;
				}
			}
			for (int i = 0; i < 3; i++) {
				int x = 0, o = 0;
				for (int j = 0; j < 3; j++) {
					if (arr[j][i] == 'X') {
						x++;
					} else if (arr[j][i] == 'O') {
						o++;
					}
				}
				if ((x == 3 || o == 3) && c1 == 0) {
					c1 = 3;
	                if(x==3){
	                   if(t1-t2==1){
	                       return true;
	                   }else return false;
	                }else if(o==3){
	                     if(t1-t2==0){
	                       return true;
	                   }else return false;
	                }
				} else if((x == 3 || o == 3) && c1 == 3) {
					return false;
				}
			}
			int k = 0, a = 0, b = 0;
			for (int i = 0; i < 3; i++) {
				if (arr[i][k] == 'X') {
					a++;
				} else if (arr[i][k] == 'O') {
					b++;
				}
			
				k++;
			}
			if ((a == 3 || b == 3) && (c1 == 3 || r1 == 3)) {
				return false;
			}else if((a == 3 || b == 3)){
	              if(a==3){
	                   if(t1-t2==1){
	                       return true;
	                   }else return false;
	                }else if(b==3){
	                     if(t1-t2==0){
	                       return true;
	                   }else return false;
	                }
	        }
	     
			k = 2;
			int c = 0, d = 0;
			for (int i = 0; i < 3; i++) {
				if (arr[i][k] == 'X') {
					c++;
				} else if (arr[i][k] == 'O') {
					d++;
				}
				
				k--;
			}
			if ((c == 3 || d == 3) && (c1 == 3 || r1 == 3)) {
				return false;
			}else if(c==3||d==3){
	              if(c==3){
	                   if(t1-t2==1){
	                       return true;
	                   }else return false;
	                }else if(d==3){
	                     if(t1-t2==0){
	                       return true;
	                   }else return false;
	                }
	        }
			return true;
		}


}
