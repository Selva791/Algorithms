package com.hacker;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ParseArray {


	    // Complete the matchingStrings function below.
	    static int[] matchingStrings(String[] strings, String[] queries) {
	    	int l=0;
	    	List<Integer> li=new ArrayList<>();
	    	for (int i = 0; i < queries.length; i++) {
	    		for (int j = 0; j < strings.length; j++) {
					if(strings[j].equals(queries[i])){
						l++;
					}

				}
	    		li.add(l);
	    		l=0;
	    		
			}
	    	int y[]=li.stream().mapToInt(k->k.intValue()).toArray();
	    	for (int i = 0; i < y.length; i++) {
				System.out.println(y[i]);
			}
        
		return y;

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {

	        String[] strings = {"aba","baba","aba","xzxb"};
    
	        String[] queries = {"aba","xzxb","ab"};

	        int[] res = matchingStrings(strings, queries);

	       

	        scanner.close();
	}

}
