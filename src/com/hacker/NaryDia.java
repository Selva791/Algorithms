package com.hacker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.hacker.NaryDiameter.Node;

public class NaryDia {
	static Node root;
	static class Node {
		char key;
		Vector<Node> child;

		Node(int val) {
			key = (char) val;
			child = new Vector<>();

		}
	}
//static int value =Integer.MIN_VALUE;
	private static int diameter(Node root2) {
		if(root2==null) {
			return 0;
			
		}
	
		int m1=0,m2=0;
		for (Node dr: root2.child) {
			int d=depth(dr);
			if(d>m1) {
				m2=m1;
				m1=d;
				
			}else if(m2<d) {
				m2=d;
				
			}
			
		}
		
		return m1+m2+1;
	}
	private static int depth(Node dr) {
		if(dr==null) {
			return 0;
		}
		int val=0;
		for (Node df: dr.child) { //re-assignment is happening.....................********
			
			val=Math.max(val,depth(df));
		}
		return val+1;
		
	}
	public static void main(String[] args) {

		 root =new Node('A'); 
		    (root.child).add(new Node('B')); 
		    (root.child).add(new Node('F')); 
		    (root.child).add(new Node('D')); 
		    (root.child).add(new Node('E')); 
		    (root.child.get(0).child).add(new Node('K')); 
		    (root.child.get(0).child).add(new Node('J')); 
		    (root.child.get(2).child).add(new Node('G')); 
		    (root.child.get(3).child).add(new Node('C')); 
		    (root.child.get(3).child).add(new Node('H')); 
		    (root.child.get(3).child).add(new Node('I')); 
		    (root.child.get(0).child.get(0).child).add(new Node('N')); 
		    (root.child.get(0).child.get(0).child).add(new Node('M')); 
		    (root.child.get(3).child.get(2).child).add(new Node('L')); 
	    System.out.print(diameter(root) + "\n"); 
	}

	

}
