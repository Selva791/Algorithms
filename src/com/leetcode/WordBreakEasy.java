package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakEasy {
public static void main(String[] args) {
	WordBreakEasy w=new  WordBreakEasy();
//	"aaaaaaa"
	//["aaaa","aaa"]
	List<String> wordDict=new ArrayList<String>();
//	wordDict.add("cats");
	wordDict.add("dog");
	wordDict.add("s");
	wordDict.add("gs");

	//wordDict.add("and");
	//wordDict.add("cat");
	
	System.out.println(w.wordBreak("dogs", wordDict));
}
public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict=new HashSet<>(wordDict);
    if(s.length()>0&&dict.isEmpty()) return false;
    if(s.length()==0&&dict.isEmpty())return true;
    Map<String,Boolean> list=new HashMap<>();
    return  breaker(s,dict,list);

}
public boolean breaker(String s,Set<String> wordDict,Map<String,Boolean> check){
 
  if(s.isEmpty()) {
	  return true;
  }
  	if(check.containsKey(s)) {
  		return check.get(s);
  		
  	}
     boolean result=false;
    for(int i=0;i<s.length();i++){
        String c=s.substring(i);
        if(wordDict.contains(c)){

      if(breaker(s.substring(0,i),wordDict,check)) {
    	  result=true;
    	 // return result;
      }

        }    
         
    }
    check.put(s,result);


    return result;
    
}
}
