package com.leetcode;

public class RotateImage {
	public static void main(String[] args) {
		int mat[][] = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}; 
			//{ { 6, 1, 2, 4, 5 }, { 7, 8, 1, 2, 3 }, { 7, 9, 10, 6, 1 }, { 3, 1, 6, 5, 7 },{ 4, 3, 6, 2, 5 } };
		RotateImage ri = new RotateImage();
		ri.rotate(mat);
		System.out.println();

	}

	public void rotate(int[][] matrix) {
		
		int n=matrix.length;
		int m=matrix[0].length;
		int t[]= {n-1,0};
		int u[]= {0,0};
		int v[]= {0,m-1};
		int w[]= {n-1,m-1};
		int i=0;
		if(m%2==0)
		i=(m/2)+1;
		else if(m%2>0){
			i=m/2;
		}
		
		int j=0;
		while(j<i) {
			
			
			
			int p[]=new int[] {t[0],t[1]};
			int q[]=new int[] {u[0],u[1]};
			int r[]= new int[]{v[0],v[1]};
			int s[]= new int[]{w[0],w[1]};
			
			while(p[0]>q[0]) {
				int a=matrix[q[0]][q[1]];
				matrix[q[0]][q[1]++]=matrix[p[0]][p[1]];
				
				int b= matrix[r[0]][r[1]];
				matrix[r[0]++][r[1]]=a;
				
				int c=matrix[s[0]][s[1]];
				matrix[s[0]][s[1]--]=b;
				
				matrix[p[0]--][p[1]]=c;
			
				
			}
			j++;
			t[0]--;
			t[1]++;
			u[0]++;
			u[1]++;
			v[0]++;
			v[1]--;
			w[0]--;
			w[1]--;
			
		}

	}
}
