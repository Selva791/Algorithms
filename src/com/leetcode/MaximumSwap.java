package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSwap {
	public static void main(String[] args) {
		MaximumSwap m=new MaximumSwap();
		m.maximumSwap(98368);
	}
	 public int maximumSwap(int num) {
	        char[] digits = Integer.toString(num).toCharArray();
	        
	        int[] buckets = new int[10];
	        for (int i = 0; i < digits.length; i++) {
	            buckets[digits[i] - '0'] = i;
	        }
	        
	        for (int i = 0; i < digits.length; i++) {
	            for (int k = 9; k > digits[i] - '0'; k--) {
	                if (buckets[k] > i) {
	                    char tmp = digits[i];
	                    digits[i] = digits[buckets[k]];
	                    digits[buckets[k]] = tmp;
	                    return Integer.valueOf(new String(digits));
	                }
	            }
	        }
	        
	        return num;
	    }
	 public int maximumSwaps(int num) {
	        String nums=num+"";
	        int n=nums.length();
	        int[] real=new int[n];
	        int[] sorted=new int[n];
	        Map<Integer,Integer> mp=new HashMap<>();
	        for(int i=0;i<n;i++){
	            int t=nums.charAt(i)-'0';
	            real[i]=t;
	            sorted[i]=t;
	            if(!mp.containsKey(t))mp.put(t,i);
	        }
	        Arrays.sort(sorted);
	        int t1=0;
	        int t2=n-1;
	        while(t1<t2){
	            int temp=sorted[t1];
	            sorted[t1]=sorted[t2];
	            sorted[t2]=temp;
	            t1++;
	            t2--;
	            
	        }
	        for(int i=0;i<n;i++){
	            if(sorted[i]!=real[i]){
	            	int s=real[i];
	            	int ind=mp.get(sorted[i]);
	            	real[i]=sorted[i];
	            	real[ind]=s;
	            	break;
	            }
	            
	        }
	        int total=0;
	        for(int i=0;i<n;i++){
	            total=real[i]+total*10;
	        }
	        return total;
	    }

}
