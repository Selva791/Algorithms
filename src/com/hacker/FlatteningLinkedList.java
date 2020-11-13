package com.hacker;
//https://www.geeksforgeeks.org/flattening-a-linked-list/
public class FlatteningLinkedList {
	Node head;
	static class Node{
		int data;
		Node right,down;
		Node(int val){
			data=val;
			right=down=null;
			
		}
	}
	
	private Node push(Node value, int i) {
		// TODO Auto-generated method stub
	
		Node newNode=new Node(i);
		newNode.down=value;
		value=newNode;
		return value;
	}
	
	public static void main(String[] args) {
/* 			5 -> 10 -> 19 -> 28 
            |    |     |     | 
            V    V     V     V 
            7    20    22    35 
            |          |     | 
            V          V     V 
            8          50    40 
            |                | 
            V                V 
            30               45 */
		FlatteningLinkedList L=new FlatteningLinkedList();
		L.head = L.push(L.head, 30); 
        L.head = L.push(L.head, 8); 
        L.head = L.push(L.head, 7); 
        L.head = L.push(L.head, 5); 
  
        L.head.right = L.push(L.head.right, 20); 
        L.head.right = L.push(L.head.right, 10); 
        
  
        L.head.right.right = L.push(L.head.right.right, 50); 
        L.head.right.right = L.push(L.head.right.right, 22); 
        L.head.right.right = L.push(L.head.right.right, 19); 
  
        L.head.right.right.right = L.push(L.head.right.right.right, 45); 
        L.head.right.right.right = L.push(L.head.right.right.right, 40); 
        L.head.right.right.right = L.push(L.head.right.right.right, 35); 
        L.head.right.right.right = L.push(L.head.right.right.right, 20); 
  
        // flatten the list 
        L.head = L.flatten(L.head); 
  
        L.printList(); 
	}
	private void printList() {
		// TODO Auto-generated method stub
		Node  value=head;
		
		while(value.down!=null) {
			System.out.println(value.data);
			value=value.down;
		}
		
	}
	

	private Node merge(Node a, Node b) {
		// TODO Auto-generated method stub
		if(a==null) {
			return b;
		}
		if(b==null) {
			return a;
		}
		Node result;
		if(a.data<b.data) {
			result=a;
			result.down=merge(a.down,b);
		}else {
			result=b;
			result.down=merge(a,b.down);
		}
		return result;
	}
	
	private Node flatten(Node flat) {
		// TODO Auto-generated method stub1
		if(flat==null|| flat.right==null) {
			return flat;
		}
		flat.right=flatten(flat.right);
		flat=merge(flat,flat.right);
		
		return flat;
	}


}
