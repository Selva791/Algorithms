package com.hacker;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	public List<String> findWords(char[][] board, String[] words) {
	int y=board[0].length;
	
	System.out.println(y);
		System.out.println(board.length);

		List<String> li=new ArrayList<String>();
		int l2 = 0;
		for (int h = 0; h < words.length; h++) {
			boolean v[][]=new boolean[board.length][y];
		
		for (int i = 0; i < board.length; i++) {
			l2=0;
			for (int j = 0; j < y; j++) {
				//System.out.println(words[h].length());
				if(h<words.length&&l2<words[h].length()) {
				if (board[i][j] == words[h].charAt(l2)) {
					v[i][j]=true;
					l2++;
					int[] s1 = { 0, 1, 0, -1 };
					int[] s2 = { -1, 0, 1, 0 };
					int d1=i;
					int d2=j;
					int f1 = i;
					int f2 = j;
					for (int k = 0; k < s2.length; k++) {
						f1 = d1+s1[k];
						f2 = d2+s2[k];
						
						if (l2<words[h].length()&&f1>=0&&f2>=0 && f1<board.length&&f2<y&&
								board[f1][f2] == words[h].charAt(l2)&&!v[f1][f2]) {
							v[f1][f2]=true;
							d1=f1;
							d2=f2;
							l2++;
							k=0;
							k--;

						}else {
							f1=d1;
							f2=d2;
						}
						if(words[h].length()==l2) {
							li.add(words[h]);
							i=0;
							j=0;
							j--;
							
							l2=0;
							h++;
							 v=new boolean[board.length][y];

							break;
						}
						
						
					}l2=0;

				}
			}

			}

		}
		}
		//System.out.println(li);
		return li;

	}

	public static void main(String[] args) {

		WordSearch wr = new WordSearch();
		char[][] board = {{'a','b'},
						{'c','d'}	
		
									};
				/*{ 'o', 'a', 'a', 'n' }, 
				{ 'e', 't', 'a', 'e' }, 
				{ 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' }*/ 

		String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};// { "a","b"/*"oath", "pea", "eat", "rain" */};

		wr.findWords(board, words);

	}

}
