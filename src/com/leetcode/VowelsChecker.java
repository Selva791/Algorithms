package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VowelsChecker {
	public static void main(String[] args) {
		VowelsChecker v=new VowelsChecker();
	
		String[] wordlist= {"ae","aa"};
		String[] queries= {"UU"};
		v.spellchecker(wordlist, queries);
	}

		public String[] spellchecker(String[] wordlist, String[] queries) {
			Set<String> st = new HashSet<>(Arrays.asList(wordlist));
			Map<String, List<String>> mp = new LinkedHashMap<>();
			Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

			for (String str : wordlist) {
				String l = str.toLowerCase();
				mp.computeIfAbsent(l, v -> new ArrayList<String>()).add(str);
			}
			String ans[] = new String[queries.length];
			for (int i = 0; i < queries.length; i++) {
				String str = queries[i];
				if (st.contains(str)) {
					ans[i] = str;

				} else if (mp.containsKey(str.toLowerCase())) {
					List<String> res = mp.get(str.toLowerCase());
					ans[i] = res.get(0);

				} else {
					String r = str.toLowerCase();
					boolean flag = false;
					for (String key : mp.keySet()) {
						if (key.length() != r.length())
							continue;

						flag = false;
						if (key.charAt(0) == r.charAt(0)
								|| (vowels.contains(key.charAt(0)) && vowels.contains(r.charAt(0)))) {

							for (int j = 1; j < r.toCharArray().length; j++) {

								if (key.charAt(j) != r.charAt(j)) {

									if (!vowels.contains(key.charAt(j)) || !vowels.contains(r.charAt(j))) {
										flag = true;
										break;
									}

								}
							}
							if (!flag) {
								List<String> res = mp.get(key);
								ans[i] = res.get(0);
								break;
							}
						}else {
							flag=true;
						}

					}
					if (flag) {
						ans[i] = "";
					}
				}

			}
			return ans;
		}
	}
