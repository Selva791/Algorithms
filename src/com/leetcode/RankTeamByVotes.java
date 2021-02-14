package com.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class RankTeamByVotes {
	public static void main(String[] args) {
		RankTeamByVotes c=new RankTeamByVotes();
		String votes[]= {"BCA","CAB","CBA","ABC","ACB","BAC"};
		System.out.println(c.rankTeams(votes));
	}
	 public String rankTeams(String[] votes) {
	        int n=votes.length;
	        
	       int ranks[][]=new int[26][26];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<votes[i].length();j++){
	                ranks[votes[i].charAt(j)-'A'][j]+=1;
	                
	            }
	        }
	        char c[]=votes[0].toCharArray();
	        Character temp[]=new Character[c.length];
	        for (int i = 0; i < temp.length; i++) {
				temp[i]=c[i];
			}
	     
	      Arrays.sort(temp,(a,b)->{
	    	  for(int i=0;i<26;i++) {
	    		  if(ranks[a-'A'][i]!=ranks[b-'A'][i]) {
	    			  return ranks[b-'A'][i]-ranks[a-'A'][i];
	    		  }
	    	  }
			return a-b;
	      });
	      StringBuilder sb=new StringBuilder();
	      for(char a:temp)sb.append(a);
	      return sb.toString();
	    }
}
