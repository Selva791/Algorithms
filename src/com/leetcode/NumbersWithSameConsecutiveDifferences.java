package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
	public static void main(String[] args) {
		NumbersWithSameConsecutiveDifferences n=new NumbersWithSameConsecutiveDifferences();
		n.numsSameConsecDiff(3, 7);
	}
	 List<String> res;
	    public int[] numsSameConsecDiff(int N, int K) {
	        res=new ArrayList<>();
	        StringBuilder sb=new StringBuilder("");
	        helper(N,K,sb);
	        System.out.println(res);
	        int total[]=new int[res.size()];
	        for(int i=0;i<total.length;i++){
	            int t=Integer.valueOf(res.get(i));
	            total[i]=t;
	        }
	        return total;
	    }
	    public void helper(int N,int K,StringBuilder sb){
	                if(N==0){
	                   res.add(sb.toString());
	                    return;
	                }
	        
	            for(int i=0;i<=9;i++){
	                if(i==0&&sb.length()==0){
	                    continue;
	                }else if(sb.length()>0){
	                   int c=Math.abs(Character.getNumericValue(sb.charAt(sb.length()-1))-i);
	                    if(c==K){
	                       helper(N-1,K,sb.append(i)); 
	                         sb.deleteCharAt(sb.length()-1);
	                    }
	                   
	                    
	                }else if(i>0&&sb.length()==0){
	                       helper(N-1,K,sb.append(i)); 
	                      sb.deleteCharAt(sb.length()-1);
	                }
	                
	            }
	    }
}
