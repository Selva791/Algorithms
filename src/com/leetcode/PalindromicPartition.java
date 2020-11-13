package com.leetcode;

public class PalindromicPartition {
public static void main(String[] args) {
	minCut("aab");
}
public static int minCut(String s) {
    int n=s.length();
    int arr[]=new int[n];
int dp[][]=new int[n][n];
    for(int i=1;i<=n;i++){
        for(int j=0;i+j<=n;j++){
                            
        int k=i+j-1;
           if(j==k){
            dp[j][k]=1;
        }else if(s.charAt(j)==s.charAt(k)&&i==2){
        dp[j][k]=1;
        }
        else if(dp[j+1][k-1]==1&&s.charAt(j)==s.charAt(k)){
            dp[j][k]=1;
        }else{
            dp[j][k]=0;

        }
            
        }
        
    }
    for(int i=0;i<n;i++){
        if(dp[0][i]==1){
            arr[i]=0;
            
        }else{
            arr[i]=Integer.MAX_VALUE;
            for(int j=0;j>i;j++){
            	
                if((dp[j+1][i]==1)&&(1+arr[j])<arr[i]){
                    arr[i]=1+arr[j];      
            }
        
        
              
         }
        }
    }
    return arr[n-1];
}
}
