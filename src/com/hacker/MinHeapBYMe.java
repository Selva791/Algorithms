package com.hacker;

public class MinHeapBYMe {
	static MinHeap mp;
	static int[] heap;
	static int maxSize;
	static int size;
static int Front =1;
	static class MinHeap {

		MinHeap(int size) {
			maxSize = size;
			heap = new int[maxSize + 1];
			size = 0;
			heap[0] = Integer.MIN_VALUE;

		}
	}

	private static int parent(int g) {
		if (g > 0 && g / 2 > 0) {
			return g = g / 2;
		}
		return g;

	}

	private void insert(int i) {
		if(size>=maxSize)
			return;
		
		heap[++size]=i;
		int count =size;
		if (heap[size] > heap[parent(count)]) {
			swap(count,parent(count));
			count=parent(count);

		}

	}

	private void swap(int i,int d) {
		int temp;
		temp = heap[d];
		heap[d] = heap[i];
		heap[i] = temp;
	}

	private void minHeap() {
		for (int i = size/2; i >= 1; i--) {
			Heapify(i);

		}

	}

	private  void Heapify(int pos) {
		if (!isLeaf(pos)) {
			if (heap[pos] > heap[rightChild(pos)]||heap[size] > heap[leftChild(pos)]) {
				if (heap[rightChild(pos)] < heap[leftChild(pos)]) {
					swap(pos,rightChild(pos));
					Heapify(rightChild(pos));
					
				}else if(heap[rightChild(pos)] > heap[leftChild(pos)]){
					swap(pos,rightChild(pos));
					Heapify(leftChild(pos));

				}
			}

		}
	}

	private int rightChild(int pos) {
		return (2*pos)+1;
	}

	private int leftChild(int pos) {
		// TODO Auto-generated method stub
		return 2*pos;
	}

	private boolean isLeaf(int pos) {
		if (pos > 0)
			pos = pos / 2;
		if (heap[pos] < heap[size]) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		mp = new MinHeap(15);
		MinHeapBYMe mhBM = new MinHeapBYMe();
		mhBM.insert(5);
		mhBM.insert(3);
		mhBM.insert(17);
		mhBM.insert(10);
		mhBM.insert(84);
		mhBM.insert(19);
		mhBM.insert(6);
		mhBM.insert(22);
		mhBM.insert(9);
		mhBM.minHeap();
		mhBM.print();
		delete();
	}

	private void print() {
		for (int i = 1; i <=size/2; i++) {
			 System.out.print(" PARENT : " + heap[i] 
                     + " LEFT CHILD : " + heap[2 * i] 
                     + " RIGHT CHILD :" + heap[2 * i + 1]); 
    System.out.println(); 
		}
		
	}

	private static int delete() {
		MinHeapBYMe mb=new MinHeapBYMe();
		int h=heap[Front];
		heap[Front]=heap[size--];
		mb.Heapify(Front);
		return h;
		
		
	}

}
