package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {
public static void main(String[] args) {
	LongestConsecutiveSequence l=new LongestConsecutiveSequence();
	int a[]= {100, 4, 200, 1, 3, 2};
	System.out.println(l.longestConsecutive(a));
	
}
public int longestConsecutive(int[] nums) {
    
    if (nums.length == 0)
        return 0;
    
    UnionFind UF = new UnionFind(nums.length);
    
    // same idea as optimal solution
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        // don't add duplicates!
        if (!map.containsKey(nums[i]))
            map.put(nums[i], i); // keep the associated index
    }
    
    HashSet<Integer> visited = new HashSet<>();
    
    for (int i = 0; i < nums.length; i++) {
        int curr = nums[i];
        if (map.containsKey(curr + 1) && !visited.contains(curr)) {
            UF.union(i, map.get(curr + 1)); // pass the indexes
            visited.add(curr); // don't revisit the same index 
        }   
    }
        
    return UF.largestConn;
}


class UnionFind {

int[] conn;
int largestConn;

public UnionFind(int n) {   
    this.conn = new int[n];
    this.largestConn = 1;  // default there will be one connection for any one number
    Arrays.fill(this.conn, -1);
}

public int find(int n) {
    // find the parent which is a negative element
    while (this.conn[n] >= 0) {
        n = this.conn[n];
    }
    
    return n;
}

public void union(int n1, int n2) {
    int parent1 = find(n1); // find the index of the parent
    int parent2 = find(n2);
    
    if (parent1 == parent2)
        return;
    
    // parent 2 is automatically larger!
    this.conn[parent2] += conn[parent1];
    this.conn[parent1] = parent2;
    this.conn[n1] = parent2; // increases efficiency slightly by reducing find time for future elements
    this.largestConn = Math.max(Math.abs(conn[parent2]), this.largestConn);
}
}
}
