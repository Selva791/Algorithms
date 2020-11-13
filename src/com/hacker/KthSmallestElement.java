package com.hacker;
//heap sort using min heap algorithm //Revision needed
public class KthSmallestElement {
	static int size;
	static Heap hp;
	static int heap[];

	static class Heap {

		Heap(int val) {
			size=val;
			heap=new int [val+1];
			heap[0]=Integer.MIN_VALUE;

		}
	}

	private static void smallestElement(int[][] mat,int n) {
		int l=1;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(l<=size)heap[l]=mat[i][j];
				l++;
			}
		}

		minHeapify();
	}

	private static void minHeapify() {
		for (int i = size/2; i >0; i--) {
			heapify(i);	

		}
		
	}

	private static void heapify(int d) {
		if(!isLeaf(d)) {
			if(heap[d]>heap[leftChild(d)]||heap[d]>heap[rightChild(d)]) {
				if(heap[leftChild(d)]<heap[rightChild(d)]) {
					swap(d,leftChild(d));
					heapify(leftChild(d));
				}else  {
					swap(d,rightChild(d));
					heapify(rightChild(d));
				}
				
			}
			
		}

	}

	private static void swap(int d, int value) {
		int temp;
		temp=heap[d];
		heap[d]=heap[value];
		heap[value]=temp;
		
		
	}
	static int front=1;
	  public static int delete() 
	    { 
 	        int popped = heap[front]; 
	        heap[front] = heap[size]; 
	        heap[size]=popped;
	        heapify(front);
	        size--;
	        if(size>0) {
		        delete();

	        }
	        return popped; 
	    } 
	private static int rightChild(int d) {
		return (2*d)+1;
	}

	private static int leftChild(int d) {
		return 2*d;
	}

	private static boolean isLeaf(int d) {
		if(d>=size/2&&d<=size) {
			return true;
		} 
		return false;
	}
	
	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 },
						{ 15, 25, 35, 45 },
						{ 25, 29, 37, 48 },
						{ 32, 33, 39, 50 }, 
						};
		int n=4*4;
		hp=new Heap(16);
		smallestElement(mat,n);
		delete();
		for (int i = heap.length-1; i >0 ; i--) {
			System.out.println(heap[i]);

		}
		
	}

	

}
