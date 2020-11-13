package com.leetcode;

public class CountingBits {
	public static void main(String[] args) {
		CountingBits cb=new CountingBits();
		int nums=8;
		char d='1';
		int s=d-'0';
		cb.countBits(nums);
		cb.count(nums);

	}

	//2-10, 4-100,8-1000,16-10000 all has only one 1's 
	//For example 9=8+1
	// 7=4+3; => 3=2+1;(3 can be directly taken from cached table)
	public int[] countBits(int num) {
		int result[]=new int[num+1];
		int q=1;
		int p=1;
        for(int i=1;i<=num;i++){
        	if(p==i) {
        		result[i]=1;
        		p=p<<1;			// multiplication purpose(p<<1 means p times of 2)
        		q=1;		// after every multiples of 2 count, we make q=1 bcs, 9=8+1, 10=8+2 and so on...
        	}else {
        		result[i]=result[q]+1;
        		q++;
        	}
            
        }
		return result;
        
    }
	//another naive solution
	private void count(int nums) {
		// TODO Auto-generated method stub
		int result[]=new int[nums+1];

		for (int i = 1; i <= nums; i++) {
			result[i]=countBit(i);
		}
		
	}
	public int countBit(int num) {
		int temp=0;
		while(num>0) {
			if(num%2==1) {
			temp++;
				
			}
			num=num/2;
		}
		return temp;
	}
	
}
