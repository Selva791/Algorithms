package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumDistanceToTypeWordsUsingTwoFingers {
	public static void main(String[] args) {
		MinimumDistanceToTypeWordsUsingTwoFingers m=new MinimumDistanceToTypeWordsUsingTwoFingers();
		System.out.println(m.minimumDistance("CAKE"));
	}
	
	/*Map<String, Integer> dp = new HashMap<>();
	    
	    public int minimumDistance(String word) {
	        Map<Character, int[]> keyboard = new HashMap<>();
	        char ch = 'A';
	        for(int i = 0 ; i < 6 ; i++) {
	            for(int j = 0; j < 6 && ch <= 'Z'; j++) {
	                keyboard.put(ch, new int[]{i, j});
	                ch++;
	            }
	        }

	        return helper(word, 0, keyboard, null, null);
	    }

	    private int helper(String word, int index, Map<Character, int[]> keyboard, int[] f1, int[] f2) {
	        if(index > word.length() - 1)
	            return 0;

	        String key = index+"#"+ Arrays.toString(f1)+Arrays.toString(f2);
	        if(dp.containsKey(key))
	            return dp.get(key);

	        int[] curr = keyboard.get(word.charAt(index));

	        int choice1 = distance(f1, curr)
	                        + helper(word, index + 1, keyboard, curr, f2);
	        int choice2 = distance(f2, curr)
	                + helper(word, index + 1, keyboard, f1, curr);

	        int min = Math.min(choice1, choice2);
	        dp.put(key, min);
	        return dp.get(key);
	    }


	    private int distance(int[] point1, int[] point2) {
	        // If finger is not occupied then return 0.
	        if(point1 == null) return 0;
	        
	        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
	    }*/
	  Map<Character,int[]>mp;
	    public int minimumDistance(String word) {
	        int dp[][][]=new int[27][27][300];
	        mp=new HashMap<>();
	        char t='A';
	        for(int i=0;i<6;i++){
	            for(int j=0;j<6;j++){
	                mp.put(t,new int[]{i,j});
	                t++;
	            }
	        }
	   
	       return helper(null,null,0,dp,word,null,null);
	        
	    }
	    public int  helper(Character p,Character q,int index,int dp[][][],String word,int left[],int right[]){
	        if(index>=word.length()){
	            return 0;
	        }
	        int m=p==null?0:p-'A'+1;
	        int n=q==null?0:q-'A'+1;
	        if(dp[m][n][index]>0){
	            return dp[m][n][index];
	        }
	        
	        int value[]=mp.get(word.charAt(index));
	       int a=getDistance(left,value)+helper(word.charAt(index),q,index+1,dp,word,value,right);
	        
	        int b=getDistance(right,value)+helper(p,word.charAt(index),index+1,dp,word,left,value);
	        int minDistance=Math.min(a,b);
	      // System.out.println(minDistance);
	        dp[m][n][index]=minDistance;
	        return dp[m][n][index];
	    }
	    public int getDistance(int p1[],int p2[]){
	        if(p1==null)return 0;
	        return Math.abs(p1[0]-p2[0])+ Math.abs(p1[1]-p2[1]);
	        
	    }
}
