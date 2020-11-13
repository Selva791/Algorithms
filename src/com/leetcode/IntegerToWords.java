package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToWords {
public static void main(String[] args) {
	
	IntegerToWords i=new IntegerToWords();
	System.out.println(i.numberToWords(1234567891));
	Map<String, ArrayList<String>> map=new TreeMap<>();
    List<String> check=new ArrayList<String>();

	//Collections.sort(list);
	
	
}
private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

private final String[] TWENTY = {"", "One", "Two", "Three", "Four", "Five", 
"Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
 "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
 "Sixty", "Seventy", "Eighty", "Ninety"};

public String numberToWords(int num) {
	if(num==0) {
		return "Zero";
		
	}
	StringBuilder sb=new StringBuilder();
	int index=0;
	while(num>0) {
		if(num%1000>0) {
			StringBuilder tmp=new StringBuilder();

			helper(tmp,num%1000);
            tmp.append(THOUSANDS[index]).append(" ");
            sb.insert(0, tmp);
			
		}index++;
		num=num/1000;
	}
	return sb.toString();
}
public void helper(StringBuilder tmp,int num) {
	if(num==0) {
		return;
		
	}
	else if(num<20) {
		tmp.append(TWENTY[num]).append(" ");
		return ;
	}else if(num<100) {
		tmp.append(TENS[num/10]).append(" ");

		helper(tmp,num%10);

	}else if(num>=100) {
		System.out.println(num/100);
		tmp.append(TWENTY[num/100]).append(" Hundred ");
		helper(tmp,num%100);

		
	}
}
}
