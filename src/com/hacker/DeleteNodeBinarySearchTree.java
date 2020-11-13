package com.hacker;

public class DeleteNodeBinarySearchTree {
	static Node root;

	class Node {
		Node left, right;
		int data;

		Node(int v) {
			data = v;
			left = right = null;
		}
	}

	private Node insertRecord(int i, Node ins) {
		// TODO Auto-generated method stub
		if (ins == null) {
			ins = new Node(i);
			return ins;
		}
		if (ins.data > i) {
			ins.left = insertRecord(i, ins.left);
		} else if (ins.data < i) {
			ins.right = insertRecord(i, ins.right);

		}
		return ins;
	}

	private Node deleteKey(int key, Node root2) {
		// TODO Auto-generated method stub
		//Node pair;
			if(root2 ==null) {
				return null;
			}
		if (key < root2.data) {
			root2.left=deleteKey(key, root2.left);
			
		} else if (key > root2.data) {
			root2.right=deleteKey(key, root2.right);

		} else {
			 if(root2.left==null&&root2.right==null) {
				 root2=null;
				 return root2;
			 }
			 if(root2.left==null) {
				 root2=root2.right;
				 return root2;
			 }
			 if(root.right==null) {
				 root2=root2.left;
				 return root2;


			 }
				 
			 root2.data=getMin(root2.right);
			root2.right= deleteKey(root2.data,root2.right);
		}
			return root2;
	}

	private int getMin(Node root2) {
		int min=root2.data;
		while(root2.left!=null) {
			min=root2.left.data;
			root2=root2.left;
			
		}
		return min;
	}

	private void inorder() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		DeleteNodeBinarySearchTree tree = new DeleteNodeBinarySearchTree();

		/*
		 * [5,3,6,2,4,null,7]
3
		 * Let us create following BST 50
		 * 							   / \ 
		 * 							   30 70 / \ / \ 20 40 60 80
		 */
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(2);
		tree.insert(4);
		tree.insert(7);
		//tree.insert(80);
		System.out.println("Inorder traversal of the given tree");
		tree.inorder();

		System.out.println("\nDelete 20");
		tree.deleteKey(3, root);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder();

		System.out.println("\nDelete 30");
		tree.deleteKey(30, root);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder();

		System.out.println("\nDelete 50");
		tree.deleteKey(50, root);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder();
	}

	private void insert(int i) {
		// TODO Auto-generated method stub
		 root=insertRecord(i, root);

	}

}
