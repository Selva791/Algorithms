package com.hacker;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListRearrange {
	Node head;

	class Node {
		Node next;
		int value;

		Node(int d) {
			value = d;
			next = null;
		}
	}

	private void reArrange(LinkedList<Character> li) {
		LinkedList<Character> idea = new LinkedList<>();
		// Collections.sort(li);
		//char d = 'a';
		char e = 'z';
		boolean f = true;
		int i = 0;
		int l=0;
		for (char d = 'a'; d < e;) {
			l=0;
			for (int j = 0; j < li.size(); j++) {
				if (li.get(j) == d) {
					idea.add(li.get(j));
					li.remove(j);
					j--;
					d++;
				l++;

				}

			}
		if(l==0) {
			break;
		}

		}
		l=0;
		for (char j = 'z'; j >= 'a'; ) {
			l=0;
			for (int j2 = 0; j2 < li.size(); j2++) {
				
				if (li.get(j2) == j) {
					idea.add(li.get(j2));
					li.remove(j2);
					j--;
					j2--;
					l++;

				}
			}
			if(l==0) {
				break;
			}
		}
System.out.println(idea);
	}

	public static void main(String[] args) {
		LinkedListRearrange lr = new LinkedListRearrange();

		LinkedList<Character> li = new LinkedList<>();
		li.add('a');
		li.add('x');
		li.add('b');
		li.add('y');
		li.add('c');
		li.add('z');
		lr.reArrange(li);

	}

}
