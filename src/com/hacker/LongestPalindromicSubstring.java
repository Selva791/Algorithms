package com.hacker;

public class LongestPalindromicSubstring {
public static void main(String[] args) {
	System.out.println(longestPalindrome("bb"));
}
public static String longestPalindrome(String s) {
    int n=s.length();
    int dp[][]=new int[n][n];
    int p=0;
    int max=0;
    int start=0;
    int end=0;
    for(int i=1;i<=n;i++){
        for(int j=0;j+i<=n;j++){
            p=0;
            int k=i+j-1;
            if(j==k){
            	p++;
                dp[j][k]=1;
            }else if(s.charAt(j)==s.charAt(k)&&i==2){
                
                p++;
            dp[j][k]=1;

            }
            else if(dp[j+1][k-1]==1&&s.charAt(j)==s.charAt(k)){
                p++;
                dp[j][k]=1;
            }else{
                dp[j][k]=0;

            }
            if(p>=max){
                start=j;
                end=k;
                max=p;

            }
        }
        
    }
    return s.equals("")? "":s.substring(start,end+1);
}
}
