package com.leetcode;

import java.util.HashMap;

public class PathSumIII {

	public static void main(String[] args) {
		PathSumIII p = new PathSumIII();
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(-3);
		root.right.right = new TreeNode(11);

		root.left = new TreeNode(5);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);

		root.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);

		root.left.left.left = new TreeNode(3);

		System.out.println(p.pathSum(root, 8));

	}

	public int pathSum(TreeNode root, int sum) {
		HashMap<Integer, Integer> preSum = new HashMap();
		preSum.put(0, 1);
		return helper(root, 0, sum, preSum);
	} 

	public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
	        if (root == null) {
	            return 0;
	        }
	        
	        currSum += root.val;
	        int res = preSum.getOrDefault(currSum - target, 0);
	        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
	        
	        res += helper(root.left, currSum, target, preSum) ;
	        res +=helper(root.right, currSum, target, preSum);
	        preSum.put(currSum, preSum.get(currSum) - 1);
	        return res;
	    }
}
