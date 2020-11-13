package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
public static void main(String[] args) {
	String s[]={"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
	GroupAnagrams f=new GroupAnagrams();
	f.groupAnagrams(s);
}
public List<List<String>> groupAnagrams(String[] strs) {
    int dict[]=new int[26];
    for(int i=0,j=10;i<dict.length;i++,j=j*10) {
    	dict[i]=j;
    	
    }
    List<List<String>> result=new ArrayList<>();
   Map<Long,List<String>> mp=new HashMap<>();
    for(int i=0;i<strs.length;i++){
        Long value=0L;
        String s=strs[i];
        for(int j=0;j<s.length();j++){
            value+=dict[(s.charAt(j))-'a'];
          
        }
          if(mp.get(value)==null){
        List<String> val=new ArrayList<>();
        val.add(s);
         mp.put(value,val);
                
            }else{
             mp.get(value).add(s);
          }
        
    }
  mp.values().stream().forEach(s->result.add(s));
  System.out.println(result);
    return result;
}
}
