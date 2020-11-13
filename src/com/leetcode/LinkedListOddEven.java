package com.leetcode;

public class LinkedListOddEven {
	static ListNode head;
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	public static void main(String[] args) {
		LinkedListOddEven loe=new LinkedListOddEven();
		head=new ListNode(2);
		head.next=new ListNode(1);
	
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(5);
		head.next.next.next.next=new ListNode(6);
		head.next.next.next.next.next=new ListNode(4);
		head.next.next.next.next.next.next=new ListNode(7);

		ListNode f=loe.oddEvenList(head);
		
		System.out.println(f);
		
		
	}
	public ListNode oddEvenList(ListNode head) {
		ListNode r=head.next;
		ListNode o=null;
		ListNode odd=odd(head);
		ListNode e=head.next.next;
		//ListNode even=even(head.next.next.next,e);
	       return null;        
	        
	    }
	ListNode n=null;
	
	   
		public ListNode odd(ListNode head){
	        if(head==null){
	        	return null;
	        }
	      
	     
	      ListNode odd=head;
	      ListNode even=head.next;
	      ListNode evenHead=even;

	          while(even!=null&&even.next!=null){
	              odd.next=odd.next.next;
	              odd=odd.next;

	              even.next=even.next.next;
	              even=even.next;  
	              
	          }
	              odd.next=evenHead;
	          return head;
	      }
	      

}

