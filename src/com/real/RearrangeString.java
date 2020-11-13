package com.real;
//https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/

import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeString {

	private static void rearrangeString(String str) {
	       int MAX_CHAR = 26;  
	       int n=str.length();
	       int count []=new int[MAX_CHAR];
	       for (int i = 0; i < n; i++) {
	    	   int s='a';
	    	   int s1=str.charAt(i);
	    	   System.out.println(s+" "+s1);
	    	   count[str.charAt(i)-'a']++;
			
		}
	       PriorityQueue<Key> pq=new PriorityQueue<>(new KeyComparator());
	       for (char i = 'a'; i <'z'; i++) {
			int value=i-'a';
			if(count[value]>0) {
				pq.add(new Key(count[value], i));
			}
	    	   
		}
	       
	       str="";
	       Key prev = new Key(-1, '#'); 
	       
           // traverse queue 
           while (pq.size() != 0) { 
             
                  // pop top element from queue and add it 
                  // to string. 
                  Key k = pq.peek(); 
                  pq.poll(); 
                  str = str + k.ch; 

                  // If frequency of previous character is less 
                  // than zero that means it is useless, we 
                  // need not to push it  
                  if (prev.freq > 0) 
                      pq.add(prev); 

                  // make current character as the previous 'char' 
                  // decrease frequency by 'one' 
                  (k.freq)--; 
                   prev = k; 
           } 

           // If length of the resultant string and original 
           // string is not same then string is not valid 
           if (n != str.length()) 
               System.out.println(" Not valid String "); 
           else
               System.out.println(str);

	}

	public static void main(String[] args) {
		String str = "bbbaa";
		rearrangeString(str);
	}

}

class Key {
	int freq;
	char ch;

	Key(int val, char c) {
		freq = val;
		ch = c;
	}
}
class KeyComparator implements Comparator<Key> {

	@Override
	public int compare(Key k1, Key k2) {
		 if (k1.freq < k2.freq) 
             return 1; 
         else if (k1.freq > k2.freq) 
             return -1; 
		 
         return 0; 
	}

}
