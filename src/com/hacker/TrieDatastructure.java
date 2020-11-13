package com.hacker;

public class TrieDatastructure {
	static int alphabets=26;
	static TrieNode root;
	static class TrieNode{
		TrieNode[] children=new TrieNode[alphabets];
			boolean endOfword=false;
		TrieNode(){
			
			for (int i = 0; i < children.length; i++) {
				children[i]=null;
			}
			
		}
		
		private static boolean search(String key) {
			int index;
			TrieNode find=root;

			for (int i = 0; i < key.length(); i++) {
				index=key.charAt(i)-'a';
				if(find.children[index]==null) {
					return false;

				}
				find=find.children[index];
				
			}
			
			
			return (find!=null&& find.endOfword);
		}
		private static void insert(String key) {
			int len=key.length();
			int index;
			TrieNode pi=root;
			for (int i = 0; i <len; i++) {
				index=key.charAt(i)-'a';
			if(pi.children[index]==null)
				pi.children[index]=new TrieNode();
				
				pi=pi.children[index];
			}
			pi.endOfword=true;
		
		}
public static void main(String[] args) {
	// Input keys (use only 'a' through 'z' and lower case) 
    String keys[] = {"the", "a", "there", "answer", "any", 
                     "by", "bye", "their"}; 
   
    String output[] = {"Not present in trie", "Present in trie"}; 
   
   
    root = new TrieNode(); 
   
    // Construct trie 
    int i; 
    for (i = 0; i < keys.length ; i++) 
        insert(keys[i]); 
   
    // Search for different keys 
    if(search("the") == true) 
        System.out.println("the --- " + output[1]); 
    else System.out.println("the --- " + output[0]); 
      
    if(search("these") == true) 
        System.out.println("these --- " + output[1]); 
    else System.out.println("these --- " + output[0]); 
      
    if(search("th") == true) 
        System.out.println("th --- " + output[1]); 
    else System.out.println("th --- " + output[0]); 
      
    if(search("thaw") == true) 
        System.out.println("thaw --- " + output[1]); 
    else System.out.println("thaw --- " + output[0]); 
     
}
 
}
}
