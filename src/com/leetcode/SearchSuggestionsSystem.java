package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
	Trie t;
	SearchSuggestionsSystem(){
		t=new Trie();
	}
	public static void main(String[] args) {
		
		SearchSuggestionsSystem s=new SearchSuggestionsSystem();
		String p[]= {"havana"}; 
				//{"mobile","mouse","moneypot","monitor","mousepad"};
		String st="tatiana";
				//"mouser";
		System.out.println(s.suggestedProducts(p, st));
	}

	class Trie {
		List<String> check=new ArrayList<>();
		boolean value = false;
		public Trie[] dict;

		Trie() {
			dict = new Trie[26];
			for (int i = 0; i < 26; i++) {
				dict[i] = null;

			}

		}
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
	        Arrays.sort(products);
	        createTrie(products);
	        return search(searchWord);
	        
	    }

	public List<List<String>> search(String search) {
		List<List<String>> result=new ArrayList<>(search.length());
		char[] temp = search.toCharArray();

		for (int i = 0; i < search.length(); i++) {
				int c=temp[i]-'a';
				
				if(t.dict[c]==null) {
					break;
				}

					t=t.dict[c];
					result.add(t.check);

				
							

		}
		while(search.length()>result.size()) {
			result.add(new ArrayList<>());
			
		}
		return result;

	}

	public void createTrie(String[] products) {
		
		int n = products.length;
		for (int i = 0; i < n; i++) {
			Trie tp=t;
			String temp = products[i];

			for (char a : temp.toCharArray()) {
				int m = a - 'a';
				if (tp.dict[m]== null) {
					
					tp.dict[m]=new Trie();
				}
					
					tp=tp.dict[m];
					
					if(tp.check.size()<3)
						tp.check.add(temp);


			}
			t.value=true;

		}

	}

}
