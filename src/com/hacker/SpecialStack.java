package com.hacker;
//https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
import java.util.Stack;

public class SpecialStack extends Stack<Integer>{
    Stack<Integer> min = new Stack<>(); 

	void push(int v) {
		if(isEmpty()==true) {
			super.push(v);
			min.push(v);

		}else {
			super.push(v);

			int m=min.pop();
			min.push(m);
			if(m>v) {
			min.push(v);	
			}else {
				min.push(m);	

			}
			//super.push(v);
			
		}
		
		
	}
	int getMin(){
		int minimum=min.pop();
		min.push(minimum);
		return minimum;
		
	}
	public static void main(String[] args) {
	   /* Stack<Integer> test= new Stack<>();
	    test.push(9);
	    test.push(9);
	    test.push(7);*/

	SpecialStack s = new SpecialStack(); 
	        s.push(10); 
	        s.push(20); 
	        s.push(30); 
	        s.push(400); 

	        //System.out.println(s.getMin()); 
	        s.push(5); 
	        System.out.println(s.getMin()); 
		
	}

}
