package com.leetcode;

import java.util.Stack;

public class SimplyfyPath {

	public static void main(String[] args) {
		SimplyfyPath s=new SimplyfyPath();
		s.simplifyPath("/a/../../b/../c//.//");
	}
	public String simplifyPath(String path) {
        int n=path.length();
        String split[]=path.split("\\/");
        Stack<String> st=new Stack<>();
        for(int i=0;i<split.length;i++){
        	String temp=split[i].trim();
            if(temp.equals("..")&&!st.isEmpty()){
                 st.pop();
            }else if(!temp.equals("..")&&!temp.equals(".")&&!temp.equals("")){
                st.push(temp);
            }
            
           
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            
            sb.insert(0,st.pop());
            sb.insert(0,'/');
            
        }
        return sb.toString();
    }
}
