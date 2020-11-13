package com.leetcode;
//https://leetcode.com/problems/couples-holding-hands/
public class MinSwapToFormCouple {
	
public static void main(String[] args) {
	int row []= {0,2,4,6,7,1,3,5}; 
		//{2,0,5,4,3,1};
	System.out.println(minimumSwap(row));
}

private static int minimumSwap(int[] row) {
	// TODO Auto-generated method stub
	  //create inverted array for positions
    int[] pos = new int[row.length];
    for(int i=0; i<row.length; i++){
        pos[row[i]] = i;
    }
    
    //now we can easily find a required spouse if we find a mismatch
    int swaps = 0;
    for(int i=0; i<row.length; i=i+2){
        int j= row[i]%2==0 ? row[i]+1 : row[i]-1;
        if(j!=row[i+1]){
            swaps++;
            swap(pos[j], i+1, row, pos);
        }            
    }
    return swaps;
}
static void swap(int i, int j, int[] row, int[] pos){
    int t = row[i];
    row[i] = row[j];
    pos[row[j]] = i;
    row[j] = t;
    pos[t] = j;
}
}
