package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternMatch {
	public static void main(String[] args) {
		String str="A man, a plan, a canal! Panama";
		String t="";
		Pattern p=Pattern.compile("[A-Za-z]");
		String s[]=str.split("[$&+,:;=?@#|'<>.-^*()%!]");
		StringBuffer sbt=new StringBuffer();

		Matcher m=p.matcher(str);
		while(m.find()) {
			sbt.append(m.group());
			//System.out.println(m.group());

		}
		System.out.println(sbt.toString());
        Map<Integer,Integer> mp=new HashMap<>();
      //  mp.entrySet().stream().filter(s1->s1.getValue()==7).collect(arg0);

		//str=str.replaceAll("[$&+,:;=?@#|'<>.-^*()%!]","").replaceAll("-", "");
		StringBuffer sb=new StringBuffer(str);
		if(sbt.reverse().toString().equalsIgnoreCase(sbt.toString())) {
			System.out.println(true);
		}
		//String s[]=str.split("(?<=\\s|^)[a-zA-Z]*(?=[.,;:]?\\s|$)\r\n");
		for (String string : s) {
			t=t+string;
		}
		System.out.println(str);
	}
}
