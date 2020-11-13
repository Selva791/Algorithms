package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsDivisibleByK {
	public static void main(String[] args) {
		CheckIfArrayPairsDivisibleByK c=new CheckIfArrayPairsDivisibleByK();
		int[] arr = {1,2,3,4,5,10,6,7,8,9};
		int k=5;
		  // Map pairs=new HashMap(9,9);
		System.out.println(c.canArrange(arr,k));
	}
	 public boolean canArrange(int[] arr, int k) {
         
	        // initialize counts of modulus
	        int modulusCounts[] = new int[k];
	        // For each number in the array, calculate modulus and update relevant count
	        for (int num: arr){
	            if((num %k) < 0)
	                modulusCounts[Math.abs(num %k)]--;
	            else
	                modulusCounts[num%k]++;
	        }
	            
	        if (modulusCounts[0] % 2 != 0) // As these will not form pair with anyone else  
	            return false;
	        
	        for (int i = 1; i <= k/2; i++)
	            if (modulusCounts[i] != modulusCounts[k-i]) 
	                return false;
	        return true;
	    }
}
