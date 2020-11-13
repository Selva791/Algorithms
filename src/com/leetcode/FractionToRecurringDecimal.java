package com.leetcode;

import java.util.HashMap;

public class FractionToRecurringDecimal {
	public static void main(String[] args) {
		FractionToRecurringDecimal f=new FractionToRecurringDecimal();
		f.fractionToDecimal(4, 333);
	}
	 public String fractionToDecimal(int numerator, int denominator) {
	        if (numerator == 0) {
	            return "0";
	        }
	        StringBuilder res = new StringBuilder();
	        // "+" or "-"
	     // StringBuilder d=res.delete(0, 7);
	        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
	        long num = Math.abs((long)numerator);
	        long den = Math.abs((long)denominator);
	        
	        // integral part
	        res.append(num / den);
	        num %= den;
	        if (num == 0) {
	            return res.toString();
	        }
	        
	        // fractional part
	        res.append(".");
	        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
	        map.put(num, res.length());
	        while (num != 0) {
	            num *= 10;
	            res.append(num / den);
	            num %= den;
	            if (map.containsKey(num)) {
	                int index = map.get(num);
	                res.insert(index, "(");
	                res.append(")");
	                break;
	            }
	            else {
	                map.put(num, res.length());
	            }
	        }
	        return res.toString();
	    }
}
