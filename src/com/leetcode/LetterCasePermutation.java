package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCasePermutation {
	public static void main(String[] args) {
		LetterCasePermutation l=new LetterCasePermutation();
		System.out.println(l.letterCasePermutation("a1b2"));
	}

	List<String> res;

	public List<String> letterCasePermutation(String S) {
		res = new ArrayList<>();
		StringBuilder sb = new StringBuilder(S);
		
		stringList(S.toCharArray(), 0);
		return res;
	}

	public void stringList(char arr[], int start) {
		
		res.add(new String(arr));
		for (int i = start; i < arr .length; i++) {
			if (Character.isLetter(arr[i]) && Character.isUpperCase(arr[i])) {
				arr[i]=Character.toLowerCase(arr[i]);
				stringList(arr, i + 1);
				arr[i]=Character.toUpperCase(arr[i]);
				
			} else if (Character.isLetter(arr[i]) && Character.isLowerCase(arr[i])) {
				arr[i]=Character.toUpperCase(arr[i]);
				stringList(arr, i + 1);
				arr[i]=Character.toLowerCase(arr[i]);
			}

		}

	}

}
