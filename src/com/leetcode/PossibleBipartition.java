package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PossibleBipartition {
	public static void main(String[] args) {
		PossibleBipartition pb = new PossibleBipartition();
		int dislikes[][] = {{1,2},{3,4},{4,5},{3,5}};
			//{{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}}
		;
		int N = 10;
		// 5
		// [[1,2],[3,4],[4,5],[3,5]]
		System.out.println(pb.possibleBipartition(N, dislikes));
	}

	LinkedList<Integer> adj[];

	public boolean possibleBipartition(int N, int[][] dislikes) {
		int visited[] = new int[N + 1];
		adj = new LinkedList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 0; i < dislikes.length; i++) {
			int arr[] = dislikes[i];
			adj[arr[0]].add(arr[1]);

		}
		for (int j = 1; j <= N; j++) {
			if (visited[j] == 0) {
				Queue<Integer> q=new LinkedList<>();
				q.add(j);
				visited[j]=1;
				while (!q.isEmpty()) {
				int size=q.size();
					 for (int i = 0; i < size; i++) {
							int v = q.poll();
							Iterator<Integer> itr = adj[v].iterator();

							while (itr.hasNext()) {
								int temp = itr.next();
								if (visited[temp] == visited[v]) {
									return false;
								}
								if (visited[temp] == 0) {
									visited[temp] = -visited[v];
									q.add(temp);

								}

							}
					 }
					

				}

		}
		}
		return true;
	}
	public boolean possibleBipartitions(int N, int[][] dislikes) {
        if (dislikes.length == 0) {
            return true;
        }
        
       LinkedList<Integer> edgeList[] ;
       edgeList=new LinkedList[N];
    		   int[] color = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i < N + 1; i++) {
			edgeList[i] = new LinkedList<>();
		}
        for (int[] dislike: dislikes) {
            edgeList[dislike[0]].add(dislike[1]);
            edgeList[dislike[1]].add(dislike[0]);
        }

        for (int index = 1; index <= N; index++) {
            if (color[index] == 0) {
                q.add(index);
                color[index] = 1;

                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int i = 0; i < size; i++) {
                        int person = q.poll();
                       Iterator<Integer> itr= edgeList[person].iterator();
                        
                        while (itr.hasNext()) {
							int temp = itr.next();
							if (color[temp] == color[person]) {
								return false;
							}
							if (color[temp] == 0) {
								color[temp] = -color[person];
								q.add(temp);

							}

						}
                    }
                }                
            }
        }

        return true;
    }

	
}
