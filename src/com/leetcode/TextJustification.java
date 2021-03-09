package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static void main(String[] args) {
		TextJustification t=new TextJustification();
		String wrd[]= {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		
		int w=20;
		System.out.println(t.fullJustify(wrd, w));
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		        List<String> ans=new ArrayList<>();
		        int n=words.length;
		        int i=0;
		        
		        while(i<n){
		             List<String> res=new ArrayList<>();
		           int len=0,alen=0;
		            while(i<n&&len<maxWidth){
		                String temp=words[i];	               
		                len+=temp.length();
		               
		                if(len<=maxWidth){
		                    res.add(temp); 
		                    alen+=temp.length();
		                     i++;
		                }
		                len+=1;
		               }
		            	  if(i==n) {
		                    int div=res.size()-1;
		                    int diff=maxWidth-alen;		                     
		                      StringBuilder sb=new StringBuilder();
		                     for(int k=0;k<res.size();k++){
		                    	 String str=res.get(k);
		                        sb.append(str);
		                        if(k<res.size()-1) {	
		                        	sb.append(" ");
		                        	diff--;
		                        }else if(k==res.size()-1){
		                        	int j=0;
		                        	while(j++<diff) {
		                        		sb.append(" ");
		                        		
		                        	}
		                        }
		                       
		                     }
		                    ans.add(sb.toString());
		                
		             }
		             else if(len>=maxWidth&&res.size()>1){
		                    int div=res.size()-1;
		                    int diff=maxWidth-alen;
		                     int sp=((diff-1)/div)+1;	             
		                      StringBuilder sb=new StringBuilder();
		                     for(String str:res){
		                        sb.append(str);
		                        if(diff>=sp) {
		                        	diff=diff-sp;
		                        	int j=0;
		                        	while(j<sp) {
		                        		sb.append(" ");
		                        		j++;
		                        	}
		                        	 div-=1;
	                                    if(div>0&&diff>0)
			                        	 sp=((diff-1)/div)+1;
		                        }else {
		                        	int j=0;
		                        	while(j++<diff) {
		                        		sb.append(" ");	                        		
		                        	}
		                        	diff=0;
		                        }
		                       
		                     }
		                    ans.add(sb.toString());
		                }else if(res.size()==1) {
		                	int v=res.get(0).length();
		                	int diff=maxWidth-v;
		                	 StringBuilder sb=new StringBuilder(res.get(0));
	                        if(diff>0) {
	                        	int j=0;
	                        	while(j<diff) {
	                        		sb.append(" ");
	                        		j++;
	                        	}
	                        }
	                        ans.add(sb.toString());
	                        
	                     }    
		        }
		        return ans;
		    }
}
