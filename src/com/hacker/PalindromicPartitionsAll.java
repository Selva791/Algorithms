package com.hacker;
//https://www.geeksforgeeks.org/print-palindromic-partitions-string/
/*Working: for "geeks"input  every character is palindrome and it undergo recursion ,everytime
i+1 (0-4,1-5,2-5,3-5,4-5).When ever the funtion finds palindrome it starts recursion for its next elements.
Since arraylist is pass by value the value wont get updated in list p when coming out of recursion
so,to get updated value we will update another list (parse object) in every recursion by assigning p's (line 17)
reference to it and p will be updated at (line 30).Every recursion completion partition gets updated
*/
import java.util.ArrayList;
import java.util.Iterator;

public class PalindromicPartitionsAll {
	
	private static ArrayList<ArrayList<String>> partition(String s, ArrayList<ArrayList<String>> partitions, ArrayList<String> p, int j) {
		// TODO Auto-generated method stub
		String str="";
		ArrayList<String> parse=new ArrayList<>(p);
		for (int i = j; i < s.length(); i++) {
			str=str+s.charAt(i);
			
			if(checkPalindrome(str)) {
				p.add(str);
				
				if(i+1<s.length()) {
					partitions=partition(s,partitions,p,i+1);
				}else {
					//p.add(s.charAt(j)+"");
					partitions.add(p);
				}
				p=parse;
			}
			
		}
		return partitions;
	}
private static boolean checkPalindrome(String str2) {
		// TODO Auto-generated method stub
	int len=str2.length();
	len--;
	for (int i = 0; i < str2.length(); i++) {
		if(str2.charAt(i)!=str2.charAt(len)) {
			return false;
		}
		len--;
	}
		return true;
	}
public static void main(String[] args) {
	String s = "geeteeks"; 
    ArrayList<ArrayList<String>> partitions = new ArrayList<>();
    starter(s, partitions);
    
}
private static void starter(String s, ArrayList<ArrayList<String>> partitions) {
	// TODO Auto-generated method stub
	ArrayList<String> p=new ArrayList<>();

	partition(s, partitions,p,0); 
	System.out.println("Input : "+p+"\n output : ");
	System.out.println(partitions);
}


}
