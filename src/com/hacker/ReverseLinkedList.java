package com.hacker;

public class ReverseLinkedList {
	static Node head;
		static class Node{
			int data;
			Node next;
			Node(int v){
				data=v;
				next=null;
			}
		}
		private static Node reverse(Node head2, int i) {
			
		Node current=head2; 
		Node next=null;
		Node  prev=null;
			int j=0;
			while(current!=null&&j<i) {
				next=current.next;	
				current.next=prev;
				prev=current;

				current=next;

				
				j++;
			}
			if(next!=null) {
				//Node r =null;
				head2.next=reverse(next, i);
			}
			System.out.println("good");
			return prev;
		}
		private void push(int i) {
				if(head==null) {
					head=new Node(i);
					return ;
				}
				Node new_node=new Node(i);
				new_node.next=head;
				head=new_node;
		}
		public static void main(String[] args) {
			ReverseLinkedList rl=new ReverseLinkedList();
			rl.push(9); 
			rl.push(8); 
			rl.push(7); 
			rl.push(6); 
			rl.push(5); 
			rl.push(4); 
			rl.push(3); 
			rl.push(2); 
			rl.push(1);
			Node n=reverse(head,3);
			print(n);
		}
		private static void print(Node n) {
			// TODO Auto-generated method stub
			if(n==null) {
				return ;
			}
			System.out.println(n.data);
			print(n.next);
			
		}
		
		
}
