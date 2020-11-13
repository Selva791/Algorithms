
package com.leetcode;

public class PermutationInString {
	public static void main(String[] args) {
		PermutationInString p=new PermutationInString();
		System.out.println(p.checkInclusion("ab", "eidboaoo"));
		//"ab"
		//"eidboaoo"
	}
	public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int arr1[]=new int[26];
        for(int i=0;i<n;i++){
            int s=s1.charAt(i)-'a';
            arr1[s]++;
        }
        int left=0;
        int right=0;
        int count=n;
        while(right<s2.length()){
            if(arr1[s2.charAt(right)-'a']>=1){
                arr1[s2.charAt(right)-'a']--;
                right++;
                count--;
            }else{
                 arr1[s2.charAt(right)-'a']--;
                right++;
            }if(count==0){
                return true;
            }
            if((right-left)==n) {
            	if(arr1[s2.charAt(left)-'a']>=0){
                 arr1[s2.charAt(left)-'a']++;
                left++;
                count++;

                
             }else{
             arr1[s2.charAt(left)-'a']++;
                left++; 
            }
            }
            
        }
        return false;
        
    }
}
