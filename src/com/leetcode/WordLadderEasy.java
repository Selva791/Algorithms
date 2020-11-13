package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class WordLadderEasy {
public static void main(String[] args) {
	WordLadderEasy wr=new WordLadderEasy();
	String s1="hit";
	String s2="cog";
	List<String> wordList=new ArrayList<String>();
	//"hit"
	//"cog"
	//["hot","dot","dog","lot","log","cog"]
	//wordList.add("dot");
	wordList.add("dot");
	wordList.add("hot");
	wordList.add("dog");
	wordList.add("log");
	wordList.add("cog");
	wordList.add("lot");



	System.out.println(wr.ladderLength(s1, s2, wordList));
}
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if(!wordList.contains(endWord))return 0;
    HashSet<String> set=new HashSet<>(wordList);
   
    return ladder(beginWord,endWord,set,1);
    
     
 }
int p=0;
class word{
	int count;
	String begin;
	word(String begin,int count){
		this.begin=begin;
		this.count=count;
		
	}
}
 public int ladder(String beginWord, String endWord, HashSet<String> set,int count){
	 Queue<word> q=new LinkedList<>();
	 q.add(new word(beginWord, 1));
	 while(!q.isEmpty()) {
		 word w=q.poll();
		 String top=w.begin;
		 char [] arr=top.toCharArray();

		 if(top.endsWith(endWord)) {
	   		  return w.count;
	   		  
	   	  }
		 for (int i = 0; i < beginWord.length(); i++) {

			 for(char a='a';a<='z';a++){
				 char temp=arr[i];
				 if(arr[i]!=a) {
					 arr[i]=a;
					 
				 }
				 String newWord=new String(arr);
			   	  if(set.contains(newWord)) {
			   		  q.add(new word(newWord,w.count+1));
			   		  set.remove(newWord);
				   	 }
			   	 arr[i]=temp;
			     }
		}
		
		 
	 }
	return 0;
	
    
 }
}
