package com.hacker;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackImplementation {
		static Queue<Integer> q1=new LinkedList<Integer>();
		static Queue<Integer> q2=new LinkedList<Integer>();
		int size=0;
		StackImplementation(){
			size=0;

		}
		private void pop() {
			
			if(q1.isEmpty()) {
				return ;
			}
			q1.remove();
			size--;
		}
		private int top() {
			// TODO Auto-generated method stub
			if(q1.isEmpty()) {
				return -1;
			}
			return q1.peek();
		}
		public void push(int i) {
			size++;
			
			q2.add(i);
			while(!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
				
			}
			Queue<Integer> q=q1;
			q1=q2;
			q2=q;
			
		}
	
public static void main(String[] args) {
	StackImplementation s=new StackImplementation();
	Stack<Integer>sd=new Stack<>();
	sd.add(3);
	sd.add(2);
	//System.out.println(sd.pop());

	s.push(6);
	s.push(7);
	s.push(4);
	s.push(2);
	s.push(1);
	System.out.println("Stack Size: "+s.size);
	s.pop();
	System.out.println("Stack top	: "+ s.top());

	

}



}
