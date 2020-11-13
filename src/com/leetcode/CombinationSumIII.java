package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public static void main(String[] args) {
		CombinationSumIII c=new CombinationSumIII();
		c.combinationSum3(3, 7);
	}
	List<List<Integer>> result;
    int count=0;
    int num=0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        count=k;
        num=n;
        result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
             helper(temp,1,0);
        return result;
    }
    public List<Integer> helper(List<Integer> temp,int index,int total){
        if(count==temp.size()&&total==num){
            
            result.add(new ArrayList<>(temp));
        }
        for(int i=index;i<=9;i++){
            if((total+i)<=num){
                
           // if(!temp.contains(i))
                temp.add(i);
                
              helper(temp,i,total+i); 
                temp.remove(temp.size()-1);
            }
            
        }
        return temp;
    }

}
