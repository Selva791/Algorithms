package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BinaryTreeColoringGame {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=new TreeNode(3);
		node.left.left=new TreeNode(4);
		node.left.right=new TreeNode(5);
		BinaryTreeColoringGame b=new BinaryTreeColoringGame();
		b.btreeGameWinningMove(node,5,2);
	}
	 Set<TreeNode> nodes;
	    Map<Integer,Set<Integer>> mp;
	    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
	        nodes=new HashSet<>();
	         mp=new HashMap<>();
	         buildGraph(root);
	        int max=Integer.MIN_VALUE;
	        int total=0;
	       
	        for(int node:mp.get(x)){
	            boolean visit[]=new boolean[n+1];
	            visit[node]=true;
	             System.out.println(node+" ");
	             int v=countNodes(node,x,visit);
	             System.out.println(" count "+v+" ");
	            total+=v;
	            max=Math.max(v,max);
	        }
	        int diff=total-max;
	        System.out.println(diff+ "  "+ total+" "+max);
	        if(diff<max)return true;
	        
	        return false;
	    }
	    public int countNodes(int node,int x,boolean visit[]){
	        int count=1;
	        for(int v:mp.get(node)){
	            if(visit[v]||v==x)continue;
	            
	            visit[v]=true;
	            count+=countNodes(v,x,visit);
	        }
	        return count;
	        
	    }
	    public void buildGraph(TreeNode root){
	        if(root==null){
	            return ;
	        }
	        if(root.left!=null){
	            if(!mp.containsKey(root.val)){
	                mp.put(root.val,new HashSet<Integer>());
	            }
	            Set<Integer> nt=mp.get(root.val);
	            nt.add(root.left.val);
	            
	            if(!mp.containsKey(root.left.val)){
	                mp.put(root.left.val,new HashSet<Integer>());
	            }
	            Set<Integer> bt=mp.get(root.left.val);
	            bt.add(root.val);
	            
	        }
	         if(root.right!=null){
	            if(!mp.containsKey(root.val)){
	                mp.put(root.val,new HashSet<Integer>());
	            }
	            Set<Integer> nt=mp.get(root.val);
	            nt.add(root.right.val);
	            
	            if(!mp.containsKey(root.right.val)){
	                mp.put(root.right.val,new HashSet<Integer>());
	            }
	            Set<Integer> bt=mp.get(root.right.val);
	            bt.add(root.val);
	            
	        }
	        
	        buildGraph(root.left);
	        buildGraph(root.right);
	    }
	    
}
