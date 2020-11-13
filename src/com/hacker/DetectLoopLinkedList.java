package com.hacker;

import com.real.DetectLoopinLinkedList;

public class DetectLoopLinkedList {
	static Node head; 
	  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    }
    
    private void detectAndRemoveLoop(Node value) {
    	Node slow=value;
    	Node fast=value;
    	while(slow!=null&&slow.next!=null&&fast.next!=null&&fast.next.next!=null) {
    		slow=slow.next;
    		fast=fast.next.next;
    		if(slow==fast) {
    			removeLoop(slow,fast,head);
    			
    		}
    	}
    	
    	
    }
    private void removeLoop(Node slow, Node fast, Node head2) {
    	Node part1=slow;
    	Node part2=fast;
		int k=1;
		while(part1.next!=fast) {
			part1=part1.next;
			k++;
		}
		part1=head;
		part2=head;
		
		for(int i=0;i<k;i++) {
			part2=part2.next;
		}
		
		while(part1!=part2) {
			
			part1=part1.next;
			part2=part2.next;
		}
		while(part1.next!=part2) {
			part1=part1.next;
		}
		part1.next=null;
	}
	private void printList(Node printer) {
    	while(printer!=null) {
    		System.out.print(printer.data +" ");
    		printer=printer.next;
    	}
    }
public static void main(String[] args) {

	DetectLoopLinkedList list = new DetectLoopLinkedList(); 
    list.head = new Node(40); 
    list.head.next = new Node(50); 
    list.head.next.next = new Node(20); 
    list.head.next.next.next = new Node(15); 
    list.head.next.next.next.next = new Node(4); 
    list.head.next.next.next.next.next = new Node(10);
    list.head.next.next.next.next .next.next= new Node(13);
    list.head.next.next.next.next.next.next.next = new Node(6);


         head.next.next.next.next.next.next.next.next = head.next.next.next; 
    list.detectAndRemoveLoop(head); 
    System.out.println("Linked List after removing loop : "); 
    list.printList(head); 
}


}
