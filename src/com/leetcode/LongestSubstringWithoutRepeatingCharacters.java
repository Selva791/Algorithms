package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters g=new LongestSubstringWithoutRepeatingCharacters();
		String s="bpfbhmipx";
		System.out.println(g.lengthOfLongestSubstring(s));
	}
	public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        int n=s.length();
        int cur=0;int index=0;
        int result=0;
           for(int i=0;i<n;i++){
               char c=s.charAt(i);
               if(mp.get(c)==null){
                   mp.put(c,i);
                   cur++;
               }else{
                   if(cur>result)result=cur;
                   
                  index=mp.get(c);
                   while(index>=0&&mp.get(s.charAt(index))!=null){
                	   if(mp.get(s.charAt(index))==index){
                		   mp.remove(s.charAt(index));
                          
                           cur--; 
                	   }
                	   index--;
                   
                   }
                   cur+=1;
                 mp.put(c,i);

               }
               
           } 
             if(cur>result)result=cur;

        return result;
    }
}
