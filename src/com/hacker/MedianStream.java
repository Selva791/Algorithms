package com.hacker;


//https://www.geeksforgeeks.org/median-of-stream-of-running-integers-using-stl
//using Maximum Heap and Minimum Heap -My own implementation ,lengthy one
//It can be done using priority queue in a easy way(in GeeksForGeeks)
public class MedianStream {
	static int minSize;
	static int maxSize;

	static int front=1;
	static int heapMin[];
	static int heapMax[];

	MedianStream(int l) {

		heapMin = new int[l];
		heapMax=new int[l];
		heapMax[0]=Integer.MAX_VALUE;
		heapMin[0]=Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		// stream of integers
		int[] arr = new int[] { 15, 5, 10, 20, 3 };
		MedianStream ms = new MedianStream(arr.length);

		printMedian(arr);
	}

	private static int minRemove() {
		// TODO Auto-generated method stub
		int r = heapMin[front];
		heapMin[front] = heapMin[minSize--];
		minheapify(front);
		return r;
	}
	private static int maxRemove() {
		// TODO Auto-generated method stub
		int r = heapMax[front];
		heapMax[front] = heapMax[maxSize--];
		maxheapify(front);
		return r;
	}
	private static void minheapify(int d) {
		// TODO Auto-generated method stub
		if(!isminLeaf(d)) {
			
			if(heapMin[d]>heapMin[left(d)]||heapMin[d]>heapMin[right(d)]) {
				if(heapMin[left(d)]>heapMin[right(d)]) {
					swapMin(right(d),d);
					minheapify(right(d));
				}else {
					swapMin(left(d),d);
					minheapify(left(d));
				}
			}
			
		}

	}
	private static void maxheapify(int d) {
		// TODO Auto-generated method stub
		if(!ismaxLeaf(d)) {
			
			if(heapMax[d]<heapMax[left(d)]||heapMax[d]<heapMax[right(d)]) {
				if(heapMax[left(d)]<heapMax[right(d)]) {
					swapMax(right(d),d);
					maxheapify(right(d));
				}else {
					swapMax(left(d),d);
					maxheapify(left(d));
				}
			}
			
		}

	}

	private static boolean ismaxLeaf(int d) {
		if(d>=maxSize/2&&d<=maxSize) {
			return true;
		}
		
		return false;
	}

	private static int right(int d) {
		// TODO Auto-generated method stub
		return (2*d)+1;
	}

	private static int left(int d) {
		return (2*d);
		// TODO Auto-generated method stub
		
	}

	private static boolean isminLeaf(int d) {
		// TODO Auto-generated method stub
		if(d>=minSize/2&&d<=minSize) {
			return true;
		}
		
		return false;
	}

	private static void minHeapadd(int x) {
		heapMin[++minSize] = x;
		if (heapMin[minSize] < heapMin[parent(minSize)]) {
			swapMin(minSize, parent(minSize));
		}
	}
	private static void maxHeapadd(int x) {
		heapMax[++maxSize] = x;
		if (heapMax[maxSize] > heapMax[parent(maxSize)]) {
			swapMax(maxSize, parent(maxSize));
		}
	}

	private static void swapMax(int i, int j) {
		// TODO Auto-generated method stub
		int temp = heapMax[i];
		heapMax[i] = heapMax[j];
		heapMax[j] = temp;

	}
	private static void swapMin(int i, int j) {
		// TODO Auto-generated method stub
		int temp = heapMin[i];
		heapMin[i] = heapMin[j];
		heapMin[j] = temp;

	}
	private static int parent(int g) {
		// TODO Auto-generated method stub
		if (g > 0 && g / 2 > 0) {
			return g = g / 2;
		}
		return g;
	}

	private static void printMedian(int[] arr) {
		// TODO Auto-generated method stub
		int median = arr[0];
		System.out.println(median);
		int k1 = maxSize;
		int k2 = minSize;
		maxHeapadd(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			int x = arr[i];
			if (maxSize > minSize) {
				if(x<median) {
					minHeapadd(maxRemove());
					maxHeapadd(x);
				}else {
					minHeapadd(x);
					
				}
			median=(heapMax[1]+heapMin[1])/2;
				
			}else if(minSize==maxSize) {
				if(x<median)  {
					maxHeapadd(x);
					median=heapMax[1];
					
				}else {
					minHeapadd(x);
					median=heapMin[1];	
				}
				
				
			}else {
				if(x>median) {
					maxHeapadd(minRemove());
					minHeapadd(x);
				}else {
					maxHeapadd(x);
				}
			median=(heapMax[1]+heapMin[1])/2;
				
				
			}
			System.out.println(median);

		}

	}

}
