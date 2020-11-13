package com.hacker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PartitionTable {
	public static void main(String[] args) {
		String f="ababcbacadefegdehijhklij";
		PartitionTable p=new PartitionTable();
		System.out.println(p.partitionLabels(f));
	}
	  public List<Integer> partitionLabels(String S) {
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
