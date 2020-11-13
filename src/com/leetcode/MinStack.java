package com.leetcode;

import java.util.Stack;

public class MinStack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-3);
		minStack.push(0);
		minStack.push(-2);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top();    // return 0
		minStack.getMin(); // return -2
	}
	private Stack<Integer> mStack = new Stack<Integer>();
	private Stack<Integer> mMinStack = new Stack<Integer>();

	public void push(int x) {
		mStack.push(x);
		if (mMinStack.size() != 0) {
			int min = mMinStack.peek();
			if (x <= min) {
				mMinStack.push(x);
			}
		} else {
			mMinStack.push(x);
		}
	}

	public void pop() {
		int x = mStack.pop();
		if (mMinStack.size() != 0) {
			if (x == mMinStack.peek()) {
				mMinStack.pop();
			}
		}
	}

	public int top() {
		return mStack.peek();
	}

	public int getMin() {
	    return mMinStack.peek();
	}
}
