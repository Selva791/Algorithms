package com.hacker;

import com.hacker.BinaryTreeDiagonal.Node;

public class BinaryTreeToBst {
	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	private static void binaryTreeToBST(Node root) {
		if(root==null) {
			
		}
		int c = 0;
		int count=countFinder(root,1);
		System.out.println(count);
		int arr[]=new int[count];
		addToArray(arr,root,0);
		quickSort(arr,0,arr.length-1);
		convertToBST(arr,root,0);

	}
	private static int convertToBST(int[] arr, Node root,int i) {
		if(root==null) {
			return i;
		}
		int c=convertToBST(arr,root.left,i);
		root.data=arr[c];
		
		c=convertToBST(arr, root.right, c+1);
		return c;
	}
	private static void quickSort(int[] arr, int i, int j) {
		if(i<j) {
			int pi=partition(arr,i,j);		
			quickSort(arr, i, pi-1);
			quickSort(arr, pi+1, j);
		}
		
	}
	private static int partition(int[] arr, int low, int high) {
		int pivot=arr[high];
		int lower=low-1;
		for (int i = low; i < high; i++) {
			if(arr[i]<=pivot) {
				lower++;
				
				int temp=arr[lower];
				arr[lower]=arr[i];
				arr[i]=temp;
				
			}
			
		}
		int temp=arr[lower+1];
		arr[lower+1]=arr[high];
		arr[high]=temp;
		return lower+1;
		
	}
	private static int addToArray(int[] arr, Node node,int i) {
			if(node==null) {
				return i-1;
			}
			arr[i]=node.data;
			
		int f=addToArray(arr, node.left,i+1);
		
		f=addToArray(arr, node.right, f+1);
		return f;
		
	}
	private static int countFinder(Node root,int c) {
		if(root==null) {
			return c-1;
		}
		
		int cout=countFinder(root.left,c+1);
		
		cout=countFinder(root.right,cout+1);

		return cout;
	}
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(30);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(5);
		
		binaryTreeToBST(root);
	}
	

}
