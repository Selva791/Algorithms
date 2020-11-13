package com.real;

import java.util.HashMap;
import java.util.Map;

public class VowlesEven {
	public int findTheLongestSubstrin(String s) {
		int ret = 0;
		//Map<String, Integer> m = new HashMap<String, Integer>();
		int []m=new int [256];
		// Map<Character, Integer> cnt =new HashMap<>();
		int[] cnt = new int[256];
		//m[];
		char vowels[] = { 'a', 'e', 'i', 'o', 'u' };
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			cnt[x]++;
			boolean ok = false;

			int temp = 0;
			for (int j = 0; j < vowels.length; j++) {
				temp += ((cnt[vowels[j]]) % 2);
			}
			if(m[temp]>0) {
	            ret = Math.max(ret, i - m[temp]);

			}else {
				m[temp]=i;
			}

		}
		return ret;
	}

	public static void main(String[] args) {
		VowlesEven ve = new VowlesEven();
		System.out.println(ve.findTheLongestSubstrin("aqwrteaikjeaghev"));
	}
}
