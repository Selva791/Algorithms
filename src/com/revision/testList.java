package com.revision;

import java.util.ArrayList;
import java.util.List;

public class testList {
public static void main(String[] args) {
	String s="Hello";
	List<String> parts=new ArrayList<String>();
	recursion(s,parts,0);
	System.out.println(parts);
}

private static void recursion(String s, List<String> parts, int i) {
	// TODO Auto-generated method stub
	String str="";
	if(i<s.length()) {
		str=str+s.charAt(i);
		parts.add(str);
		recursion(s,parts,i+1);
System.out.println();
	}
}
}


