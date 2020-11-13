package com.leetcode;

public class ShuffleString {
public static void main(String[] args) {
	ShuffleString s=new ShuffleString();
	int indices[]={4,5,6,7,0,2,1,3};
	System.out.println(s.restoreString("codeleet", indices));
}
public String restoreString(String s, int[] indices) {
    StringBuilder sb=new StringBuilder(s);
    int n=indices.length;
    for(int i=0;i<n;i++){
        int d=indices[i];
       sb.replace(d, d+1, s.charAt(i)+"");
        
    }
    return sb.toString();
}
}
