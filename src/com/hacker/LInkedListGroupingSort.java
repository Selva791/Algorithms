package com.hacker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//Not a Optimised solution---- OWN attempt--simply wasted 3 days Fuck!!!!!!!

public class LInkedListGroupingSort {
	static Node head;

	static class Node {
		Node next;
		int data;

		Node(int value) {
			data = value;
			next = null;
		}
	}

	static List<Integer> li = new ArrayList<Integer>();

	private static List<Integer> group(Node hd) {
		// TODO Auto-generated method stub
		if (hd == null || hd.next == null) {
			return li;
		}

		int m = hd.next.data + hd.data;
		li.add(m);
		group(hd.next.next);

		// result=result.next;
		return li;

	}

	private static Node groupSort(Node head2) {
		Collections.sort(li);
		// Collections.reverse(li);
		Node result = null;

		for (Integer integer : li) {
			int m = 0;
			Node itr = head;
			while (itr != null && itr.next != null) {
				m = itr.next.data + itr.data;
				if (integer == m) {
					result = pushNode(result, itr);

				}
				itr = itr.next.next;

			}
		}
		return result;
	}

	private static Node pushNode(Node result, Node itr) {
		// TODO Auto-generated method stub

		Node n1 = new Node(itr.data);
		Node n2 = new Node(itr.next.data);

		n1.next = n2;
		n1.next.next = result;
		result = n1;

		return result;

	}

	private void push(int i) {
		if (head == null)
			head = new Node(i);

		Node nd = new Node(i);
		Node temp = head;
		head = nd;
		head.next = temp;
	}

	public static void main(String[] args) {
		LInkedListGroupingSort lg = new LInkedListGroupingSort();
		lg.push(3);
		lg.push(4);
		lg.push(2);
		lg.push(0);
		lg.push(7);
		lg.push(1);
		lg.push(5);
		lg.push(0);
		lg.push(3);
		lg.push(1);
		group(head);
		Node fine = groupSort(head) ;
		System.out.println("Finally DUmmy Solution" );
		printer(fine);

	}

	private static void printer(Node fine) {
		while (fine != null) {
			
			System.out.print(fine.data + " ");
			fine = fine.next;

		}
	}

}
