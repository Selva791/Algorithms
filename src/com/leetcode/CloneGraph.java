package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

 public class CloneGraph {
	public static void main(String[] args) {
		CloneGraph c=new CloneGraph();
		Node node=new Node(1);
		Node t1=new Node(2);
		Node t2=new Node(4);
		node.neighbors.add(t1);
		node.neighbors.add(t2);
		Node t3=new Node(3);
		t3.neighbors.add(t1);
		t3.neighbors.add(t2);
		t2.neighbors.add(node);
		t2.neighbors.add(t3);
		t1.neighbors.add(node);
		t1.neighbors.add(t3);

		int mat[][]= {{2,4},{1,3},{2,4},{1,3}};
	
		c.cloneGraph(node);
	}
	public Node cloneGraph(Node node) {
         if(node==null)return null;
         Node res=new Node(node.val);
        Map<Node, Node> check=new HashMap<>();
        helper(node,res,check);
        return res;
        
    }
    
    
    public void helper(Node node,Node value,Map<Node, Node> check){
        if(node==null)return;
        
        if(check.containsKey(node)) {
        	 value.neighbors.add(check.get(node));
        	 return;
        }
        Stack<Integer> res=new Stack<>();
        res.stream().mapToInt(i->i).toArray();        
        check.put(node, value);
        for(Node n:node.neighbors){
        	Node temp=new Node(n.val);
            value.neighbors.add(temp);
            helper(n,temp,check);
        }
        return;
    }
    static class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
 