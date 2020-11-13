package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
	public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber l=new LetterCombinationsOfPhoneNumber();
		String digits="236";
		l.letterCombinations(digits);
	}
	 public List<String> letterCombinations(String digits) {
         Map<Character,String> pairs=new HashMap<>();
     pairs.put('1',"");
     pairs.put('2',"abc");
     pairs.put('3',"def");
     pairs.put('4',"ghi");
     pairs.put('5',"jkl");
     pairs.put('6',"mno");
     pairs.put('7',"pqrs");
     pairs.put('8',"tuv");
     pairs.put('9',"wxyz");
     
     int n=digits.length();
     String [] set=new String[n];
         for(int i=0;i<n;i++){
             set[i]=pairs.get(digits.charAt(i));
             
         }
     StringBuilder sb=new StringBuilder();
     combinations(sb,set,0);
     
     return null;
     
 }
 public void combinations(StringBuilder sb,String [] set,int index){
	 if(index>=set.length) {
	     System.out.println(sb.toString());

	 }
	 String s="";
     if(index<set.length)
     s=set[index];
     
     for(int i=0;i<s.length();i++){
      sb.append(s.charAt(i));

         combinations(sb,set,index+1);
         sb.deleteCharAt(sb.length()-1);
     }
     
 }
}
