package com.hacker;

public class LinkedListMergeSort {
	static Node head;

	static class Node {
		Node next;
		int data;

		Node(int v) {
			data = v;
			next = null;

		}
	}

	private static Node mergeSort(Node value) {
		// TODO Auto-generated method stub
		if(value==null||value.next==null) {
			
			return value;
		}
		
		Node mid=midNode(value);
		Node middle=mid.next;
		mid.next=null;
		Node left=mergeSort(value);
		Node right=mergeSort(middle);
		Node sort=sortAndMerge(left,right);
		return sort;
	}
	
	private static Node sortAndMerge(Node mid, Node value) {
		// TODO Auto-generated method stub
		if(mid==null) {
			return value;
			
		}
		if(value==null) {
			return mid;
		}
		Node result;
		if(value.data>mid.data) {
			result=mid;
			result.next=sortAndMerge(result.next,value);
		}else {
			result=value;
			result.next=sortAndMerge(mid,result.next);

		}
		return result;
	}

	private static  Node midNode(Node value) {
		// TODO Auto-generated method stub
		Node slow=value;
		Node fast=value;
		while(slow!=null&&fast!=null&&fast.next!=null&&slow.next!=null&&fast.next.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			
		}
		return slow;
		
		
	}

	public static void main(String[] args) {
		LinkedListMergeSort list = new LinkedListMergeSort();
		head = list.push(head, 3);
		head = list.push(head, 6);
		head = list.push(head, 9);
		head = list.push(head, 5);
		head = list.push(head, 8);
		head = list.push(head, 7);
		head = list.push(head, 1);
		Node start = null;
		mergeSort(head);
		System.out.println("The Merge Sort Of Linked List");

		printer();
	}


	private static void printer() {
		// TODO Auto-generated method stub
		Node print=head;
		while(print!=null) {
			System.out.print(print.data+" ");
			print=print.next;
			
		}
	}

	private Node push(Node head, int i) {
		if(head==null) {
			head=new Node(i);
	
		}else {
		Node n=new Node(i);
		Node temp=head;
		head=n;
		 head.next=temp;
		}
		 return head;
		
	}

}
