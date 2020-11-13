package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKBinaryTree {
	public static void main(String[] args) {
		AllNodesDistanceKBinaryTree b = new AllNodesDistanceKBinaryTree();
		TreeNode n = new TreeNode(3);
		n.left = new TreeNode(5);
		n.right = new TreeNode(1);
		n.left.left = new TreeNode(6);
		n.left.right = new TreeNode(2);
		n.left.right.left = new TreeNode(7);
		n.left.right.right = new TreeNode(4);
		n.right.right = new TreeNode(8);
		n.right.left = new TreeNode(0);
		TreeNode target=n.left;
		//target.left=null;
		//target.right=null;
		System.out.println(b.distanceK(n, target, 2));

	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        Map<TreeNode, TreeNode> childToParent = new HashMap<TreeNode, TreeNode>();
        dfs(root, childToParent);
        String s="";
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        
        while(!queue.isEmpty() && K > 0){
            final int SIZE = queue.size();
            K--;
            
            for(int i = 0; i < SIZE; i++){
                TreeNode cur = queue.poll();
                visited.add(cur);
                
                TreeNode left = cur.left, right = cur.right;
                
                if(left != null && !visited.contains(left)) queue.add(left);
                if(right != null && !visited.contains(right)) queue.add(right);
                if(childToParent.containsKey(cur) 
                   && !visited.contains(childToParent.get(cur))) {
                    queue.add(childToParent.get(cur));
                }
            }
        }
        
        while(!queue.isEmpty()) ans.add(queue.poll().val);
        
        return ans;
    }
    
    private void dfs(TreeNode node, Map<TreeNode, TreeNode> childToParent){
        if(node.left != null) {
            childToParent.put(node.left, node);
            dfs(node.left, childToParent);
        }
        
        if(node.right != null) {
            childToParent.put(node.right, node);
            dfs(node.right, childToParent);
        }
    }
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}