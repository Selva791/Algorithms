package com.leetcode;

import java.util.Stack;

public class DecodeString {
		public static void main(String[] args) {
			DecodeString d=new DecodeString();
			System.out.println(d.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
		}
		 public String decodeString(String s) {
		        int n=s.length();
		        
		        Stack<Integer> nums=new Stack<>();
		        Stack<StringBuilder> str=new Stack<>();
		        
		        StringBuilder sb=new StringBuilder();
		        int t=0;
		        for(int i=0;i<n;i++){
		            
		           char c=s.charAt(i);
		            if(Character.isDigit(c)){
		                
		                t=t*10+(c-'0');
		               
		            }else if(c=='['){
		               str.push(sb);
		                nums.push(t);
		                t=0;
		                sb=new StringBuilder();
		            }else if(c==']'){
		                int m=0;
		               
		                StringBuilder temp=str.pop();
		                    m=nums.pop();
		                for(int j=0;j<m;j++){
		                    temp.append(sb);
		                }
		                sb=temp;
		              //  str.push(temp);
		                //sb=new StringBuilder();
		            }else {
		                sb.append(c);
		            }
		            
		        }
		        
		        
		        return sb.toString();
		    }
}
