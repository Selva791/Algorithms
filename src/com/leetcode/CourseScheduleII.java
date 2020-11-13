package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
	public static void main(String[] args) {
		CourseScheduleII cs = new CourseScheduleII();
		int numCourses = 2;
		int prerequisites[][] = { {0,1},{1,0} };
		cs.findOrder(numCourses, prerequisites);
	}

	List<Integer> adj[];
	List<Integer> result;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		adj = new ArrayList[numCourses];
		result =new Stack<>();
		for (int i = 0; i < numCourses; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int temp[] : prerequisites) {
			adj[temp[0]].add(temp[1]);

		}
		int ans[] = new int[numCourses];
		boolean visited[] = new boolean[numCourses];
		boolean reStack[] = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
				if(!visited[i]) {
					if(!topoSort(i, visited,reStack)) {
						return new int[] {};
					}
				}
				
			
			
			

		}

		for (int j = 0; j < numCourses; j++) {
			ans[j] = result.get(j);

		}

		return ans;
	}

	public boolean topoSort(int start, boolean visited[],boolean reStack[]) {
		if(reStack[start] == true) {
			return false;
		}
		
		visited[start] = true;
		reStack[start]=true;
		List<Integer> cur = adj[start];
		for (int s : cur) {
			  if(!visited[s])		        
			if(!topoSort(s, visited,reStack)) {
				return false;
			}

		}
		reStack[start]=false;

		result.add(start);
		return true;


	}
}
