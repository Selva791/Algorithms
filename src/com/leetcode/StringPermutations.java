package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	public static void main(String[] args) {
		StringPermutations s=new StringPermutations();
		System.out.println(s.getPermutation(5, 3));
	}
	public String getPermutation(int n, int k) {
        int fact[]=new int[n];
        fact[0]=1;
        List<Integer> li=new ArrayList<>();
        
        for(int i=1;i<n;i++){
            fact[i]=i*fact[i-1];
            
        }
        for(int i=1;i<=n;i++){
          li.add(i);  
        }
        k--;
        String s="";
		for(int i=n-1;i>=0;i--){
            int index=k/fact[i];
            s=s+li.remove(index);
            k=k%fact[i];
        }
        return s;
	}
	//Brute FOrce
	
	/*List<String> list ;
	int a=0;
	public String getPermutation(int n, int k) {
		list=new ArrayList<String>();
		String value = "";
		a=k;
		for (int i = 1; i <= n; i++) {
			value += (String.valueOf(i));

		}
	
		 permutations(value, "", n);
		 return list.get(k-1);
	}

	public void permutations(String value, String out,int n) {
		//System.out.println(check);
			if(a==0) {
				return;
			}
			if(value.length()==0&&a>0) {
				list.add(out);
				a--;
				//return;
				
			}
			
			
		for (int i = 0; i < value.length(); i++) {
				
			char c=value.charAt(i);
			String s=value.substring(0,i)+value.substring(i+1);
			
			permutations(s,out+c,n);
		}
	}*/
}
