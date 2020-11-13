package com.hacker;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
//https://www.geeksforgeeks.org/minimum-deletions-required-to-make-frequency-of-each-letter-unique/

public class UniqueFrequency {

	private static int minimumDeletions(char[] charArray) {
		
		int frequency[]=new int[26];
		for (int i = 0; i < charArray.length; i++) {
			frequency[charArray[i]-'a']++;
		}
		Map<Integer,Integer> mp=new TreeMap<Integer, Integer>(Collections.reverseOrder());
		 for (int j = 0; j < frequency.length; j++) {
			if(frequency[j]!=0) {
				if(mp.containsKey(frequency[j])) {
					mp.put(frequency[j], mp.get(frequency[j])+1);

				}else {
					mp.put(frequency[j], 1);
				}
			}
			
		}
	
		
		int delete=0;
		for (Entry<Integer, Integer> s : mp.entrySet()) {
			if(s.getValue()==0) {
				break;				
			}
			while(s.getValue()>1) {
			int key=s.getKey();
			int val=s.getValue();
			delete++;

			mp.put(key, mp.get(key)-1);
	
			if(mp.containsKey(key-1)) {
				mp.put(key-1, mp.get(key-1)+1);


			}
			else {
				mp.put(key-1, 1);
			}
			}
		}
			
		
		return delete;
	}

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println(minimumDeletions(s.toCharArray()));

	}

}
