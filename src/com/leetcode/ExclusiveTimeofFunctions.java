package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
	public static void main(String[] args) {
		ExclusiveTimeofFunctions e=new ExclusiveTimeofFunctions();
		int n=2;
		List<String> list=new ArrayList<String>();
		list.add("0:start:0");
		list.add("0:start:2");
		list.add("0:end:5");
		list.add("1:start:7");
		list.add("1:end:7");
		list.add("0:end:8");
		e.exclusiveTime(n, list);
	}

	 public int[] exclusiveTime(int n, List<String> logs) {
	        int ans[]=new int [n];
	        Stack<Integer> st=new Stack<>();
	        Stack<int[]> check=new Stack<>();
	        
	        int prev=0;
	        int s=0;
	        for(int i=0;i<logs.size();i++){
	            String str[]=logs.get(i).split(":");
	            
	            if(str[1].equals("start")){
	                st.push(Integer.parseInt(str[2]));
	               
	            }else{
	                int start=st.pop();
	                int end=Integer.parseInt(str[2]);
	                int diffval=(end-start)+1;
	                int j=0,f=0;
	                while(check.size()>0){
	                    if(check.peek()[0]>=start&&check.peek()[1]<=end){
	                       int diff=(check.peek()[1]-check.peek()[0])+1;
	                       diffval=diffval-diff;
                         check.pop();
	                    }else {
	                    	break;
	                    }
	                }
	                ans[Integer.parseInt(str[0])]+=diffval;
	                check.add(new int[]{start,end});
	                s++;
	                           
	            }
	            
	        }
	        return ans;
	    }
}
