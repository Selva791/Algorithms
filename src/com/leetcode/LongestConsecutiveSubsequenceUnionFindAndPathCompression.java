package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LongestConsecutiveSubsequenceUnionFindAndPathCompression {
	public static void main(String[] args) {
		LongestConsecutiveSubsequenceUnionFindAndPathCompression l=new LongestConsecutiveSubsequenceUnionFindAndPathCompression();
		int a[]= {100,4,200,1,3,2};
		System.out.println(l.longestConsecutive(a));
		Map<Integer,int[][]>mp=new HashMap<>();
		mp.put(1,new int[][] {{0,0},{0,1}});
		TreeMap<Integer,String> map = new TreeMap<Integer,String>();
		map.higherKey(4);
        Integer r=Integer.valueOf((int) Math.sqrt(3));


	}

	public int longestConsecutive(int[] nums) {
		// TODO Auto-generated method stub
		if(nums.length==0) return 0;
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			map.putIfAbsent(nums[i],i);
		}
		UnionFind uf=new UnionFind(nums.length);
		Set<Integer> s=new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int p=nums[i];
			if(map.containsKey(p+1)&&!s.contains(p)) {
				uf.union(i,map.get(p+1));
				s.add(p);
			}
		}
		return uf.longerValue;
	}

	class UnionFind{
		int conn[];
		int rank[];
		int longerValue=0;
		 UnionFind(int l){
			 conn=new int[l];
			 rank=new int[l];
			 longerValue=1;
			 for (int i = 0; i < l; i++) {
				conn[i]=i;
				rank[i]=1;
			}
			
		}
		public void union(int i, int j) {
			
			int p1=find(i);
			int p2=find(j);
			if(p1==p2)return ;
			int idea=1;
			if(rank[p1]>rank[p2]) {
				conn[p2]=p1;

				rank[p1]+=rank[p2];
				idea=rank[p1];
				
			}else {
				
				conn[p1]=p2;

				rank[p2]+=rank[p1];
				idea=rank[p2];

			}
			longerValue=Math.max(idea, longerValue);
		}
		public int find(int n) {
			while(conn[n]!=n) {
				n=conn[n];
				
			}
			return n;
		}
		
	}
	
	

}
