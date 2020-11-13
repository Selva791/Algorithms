package com.hacker;

public class SortedDoublyCircularLinkedList {
	static Node head;

	static class Node {
		Node prev, next;
		int data;

		Node(int v) {
			prev = next = null;
			data = v;
		}
	}

	private static void sortedInsert(Node head2, int key) {
		// TODO Auto-generated method stub
		Node current = head2;
		if (current == null) {
			current = new Node(key);
			current.next = current.prev = current;
			head = current;
			return;

		}
		while (current.data < key && current.next!= head2) {
			current = current.next;
		}
		Node next = current.next;
		if (current.data > key && current.data == head2.data) {
			Node pre = current.prev;
			Node n = new Node(key);

			current.prev = n;
			n.next = current;
			n.prev = pre;
			pre.next = n;
			current = current.prev;
			head = current;

		}
		if (current.data < key /* && current.next.data == head2.data */) {
			Node nxt = current.next;
			Node n = new Node(key);
			current.next = n;
			n.prev = current;
			n.next = nxt;
			nxt.prev = n;

		}
		if (current.data > key /* && current.next.data == head2.data */) {
			Node nxt = current;
			Node prev=current.prev;
			Node n = new Node(key);
			prev.next = n;
			n.prev = prev;
			n.next = nxt;
			nxt.prev = n;

		}

	}

	private static void printList(Node head2) {
		// TODO Auto-generated method stub
		System.out.println();
		while (head2 != null&&head!=head2.next) {
			System.out.print(head2.data + " ");
			head2 = head2.next;
		}
		System.out.print(head2.data);
	}

	public static void main(String[] args) {

		// insert the following nodes in sorted way
		sortedInsert(head, 8);
		sortedInsert(head, 5);
		sortedInsert(head, 3);
		sortedInsert(head, 10);
		sortedInsert(head, 12);
		sortedInsert(head, 9);

		System.out.println("Created Doubly Linked List");
		printList(head);
	}

}
