package com.leetcode;

public class MonotoneIncreasingDigits {
	public static void main(String[] args) {
		MonotoneIncreasingDigits m=new MonotoneIncreasingDigits();
		m.monotoneIncreasingDigits(2345176);
	}

	public int monotoneIncreasingDigits(int N) {
				String num = N + "";
				int n = num.length();
				if (n == 1) {
					return N;
				}
				if (n == 2) {
					if (num.charAt(0) == '1') {
						return 9;
					}
				}
				int firstInd = -1;
		        boolean flag=false;
				int temp =N%10;
		      int i=n-2;
		      int value=N/10;
				while (value>0) {
					int r=value%10;
					if ((temp < r)||(temp==r&&flag)) {
						firstInd = i;
						temp = r;
		                flag=true;
					}else if(temp >r){
		               temp = r; 
		                flag=false;
		            }
		            i--;
					value=value/10;
				}
		      if(firstInd==-1)return N;
		        int index=n-1;
		      int dup=N;
		      int remain=0;
		      int mul=1;
				while(dup>0){
		           
		            if(index>firstInd){
		                remain=remain*10;
		                remain+=9;
		                mul*=10;
		                
		            }else if(index==firstInd) {
		            	 int t=((dup%10)-1)*mul;
			                remain+=t;
			                mul*=10;
		            }else{
		                int t=(dup%10)*mul;
		                remain+=t;
		                mul*=10;
		            }
		            index--;
		            dup=dup/10;
		        }

				return remain;

	}
}
