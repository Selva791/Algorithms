package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class FlattenMultilevelDoublyLinkedList {
	static Node head;
	static class Node {
		      int val;
		      Node next;
		      Node prev;
		      public Node child;

		      Node() {}
		      Node(int val) { this.val = val;
		      
		      }
		     Node(int val, Node next) { this.val = val; this.next = next; }
		  }
public static void main(String[] args) {
	FlattenMultilevelDoublyLinkedList flat=new FlattenMultilevelDoublyLinkedList();
	head=new Node(37099);
	Node v=head.next=new Node(10580);
	v.prev=head;
	Node u=v.next=new Node(33214);
	u.prev=v;
	Node s=u.next=new Node(85010);
	s.prev=u;
	Node m=s.next=new Node(91986);
	m.prev=s;
	Node n=m.child=new Node(85793);
	Node p=n.next=new Node(98560);
	p.prev=n;
	Node f=p.child=new Node(27598);
	f.child=new Node(40623);
	Node h=f.next=new Node(81763);
	h.prev=f;
	Node q=p.next=new Node(46360);
	q.prev=p;
	Node g=q.next=new Node(50155);
	g.prev=q;
	Node r=g.next=new Node(37244);
	r.prev=g;
	Node e=m.next=new Node(30187);
	e.prev=m;
//[37099,10580,33214,85010,91986,30187,null,85793,98560,46360,50155,37244,null,null,null,27598,81763,null,40623]

	
	flat.flatten(head);
	
}
public Node flatten(Node head) {
	Node value=new Node(head.val);
    flat(head);
    return value;
    
    
}
public Node flat(Node head){
	Stack<Node> st=new Stack<>();
	if(head==null) {
		return null;
	}
   
    Node idea=head;
    Node temp;
    	while(head!=null) {
    		if(head.child!=null) {
    			temp=head.child;
    			if(head.next!=null) {
        			st.push(head.next);

    			}

    			head.next=temp;
    			if(head.next!=null)
    			temp.prev=head;
    			
    			head.child=null;
    			head=head.next;
    			
    		}else {
    			if(head.next==null&&!st.isEmpty()) {
    				Node t=st.pop();
    				head.next=t;
    				if(head.next!=null) {
    					
    					t.prev=head;	
    				}
    				
    				
    			}
    			head=head.next;
    		}
    		
    	}
    
    return idea;
    
    
}
}
