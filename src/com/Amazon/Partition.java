package com.Amazon;

import java.util.ArrayList;
import java.util.List;

public class Partition {
	List<Integer> lengthEachScene(List<Character> inputList)
    {
		StringBuilder sb = new StringBuilder();
		for (Character ch: inputList) {
			sb.append(ch);
		}

		String S = sb.toString();
        int n=S.length();
        List<Integer> result=new ArrayList<>();
        int part[]=new int[26];
        for(int i=0;i<n;i++){
            int a=S.charAt(i)-'a';
            part[a]=i;
        }
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            int a=S.charAt(i)-'a';
            end=Math.max(part[a],end);
            if(end==i){
            result.add(end-start+1);
            
            start=end+1;
            }
            
        }
       return result;
    }
}
