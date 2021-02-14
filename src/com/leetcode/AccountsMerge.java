package com.leetcode;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class AccountsMerge {
	public static void main(String[] args) {
		AccountsMerge a=new AccountsMerge();
		List<List<String>> result = new ArrayList<>();
		result.add(Arrays.asList("David","David0@m.co","David1@m.co"));
		result.add(Arrays.asList("David","David3@m.co","David4@m.co"));
		result.add(Arrays.asList("David","David4@m.co","David5@m.co"));
		result.add(Arrays.asList("David","David2@m.co","David3@m.co"));
		result.add(Arrays.asList("David","David1@m.co","David2@m.co"));
		a.accountsMerge(result);
		
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, Integer> mp = new HashMap<>();
		Map<Integer,String> value = new HashMap<>();
		Map<String,String> check = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		String temp="";
		int c = 0;
		for (int i = 0; i < accounts.size(); i++) {
			for (int j = 0; j < accounts.get(i).size(); j++) {
				if (j != 0) {
					String t = accounts.get(i).get(j);
					if(!mp.containsKey(t)) {
						   mp.put(t, c);
						   value.put(c, t);
						   check.put(t, temp);
						   c+=1;

					}
				}else {
					temp=accounts.get(i).get(j);
				}
			}
		}
		int n = mp.size();

		int parents[] = new int[n];
		Arrays.fill(parents, -1);
		for (int i = 0; i < accounts.size(); i++) {
			for (int j = 0; j < accounts.get(i).size(); j++) {
				if (j != 0 && accounts.get(i).size() > j + 1) {
					String t1 = accounts.get(i).get(j);
					String t2 = accounts.get(i).get(j + 1);
					int p1 = find(mp.get(t1), parents);

					int p2 = find(mp.get(t2), parents);
					if (p1 != p2) {
						union(p1, p2, parents);
					}
				}
			}

		}
		
		TreeSet<String> pq=new TreeSet<>();
			boolean visited[]=new boolean[n];	
		for (int i = 0; i < n; i++) {
			//if(parents[i]>=0)continue;
			if(visited[i])continue;
			
			   int root=find(i,parents);
				List<String> r=new ArrayList<>();
				String t=value.get(i);
				r.add(check.get(t));
				pq.add(t);
				visited[i]=true;
		
			
			for (int j = i+1; j < n; j++) {
				int rt=find(j,parents);
				if(rt==root) {
					pq.add(value.get(j));
					visited[j]=true;
				}
				
			}
			r.addAll(pq);
			result.add(r);
			pq.clear();
		}
		return result;

	}

	public int find(int a,int parents[]) {
		if (parents[a] < 0) {
			return a;
		}
		return find(parents[a], parents);
	}

	public void union(int a, int b, int parents[]) {
		if (a < b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}
}
