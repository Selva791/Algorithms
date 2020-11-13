package com.hacker;

//https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/	
public class MaximumDifferencebetweentwoNodes {
	Node root;

	static class Node {
		Node left, right;
		int data;

		Node(int val) {
			data = val;
			left = right = null;

		}
	}
static int finalval=0;
	private int maxDiff(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		if(node.left==null&&node.right==null) {
			return node.data;
		}
		
		int val=maxDiff(node.left);
		finalval=Math.max(finalval,Math.abs(node.data-val));
		val= maxDiff(node.right);
		finalval=Math.max(finalval,Math.abs(node.data-val));

		return Math.max(node.data,val);
	}
	//Perfect solution below
	 /* public int maxAncestorDiff(TreeNode root) {
          //  min=root.val;
          //  max=root.val;
           return maxAncestor(root,root.val,root.val);
        }
    
    public static int maxAncestor(TreeNode root,int min,int max) {
            if(root==null){
                return max-min;
            }
        if(root.val<min){
            min=root.val;
        }if(root.val>max){
            max=root.val;
        }
        int lf=maxAncestor(root.left,min,max);
       int rt= maxAncestor(root.right,min,max);
        return Math.max(lf,rt);
	
    }
*/
	public static void main(String[] args) {
		MaximumDifferencebetweentwoNodes tree = new MaximumDifferencebetweentwoNodes();

		// Making above given diagram's binary tree
		tree.root = new Node(3);
		tree.root.right = new Node(1);

		tree.root.left = new Node(0);
		tree.root.left.left = new Node(2);

		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		//tree.root.left.right.left = new Node(4);
		//tree.root.left.right.right = new Node(7);

		/*tree.root.right = new Node(10);
		tree.root.right.right = new Node(14);
		tree.root.right.right.left = new Node(13);
*/
		System.out.println("Maximum difference between a node and" + " its ancestor is : ");
		tree.maxDiff(tree.root);
		System.out.println(" "+finalval);

	}

}
