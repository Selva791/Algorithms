package com.hacker;

public class LargestTimeForGivenDigits {
	public static void main(String[] args) {
		LargestTimeForGivenDigits l = new LargestTimeForGivenDigits();
		int A[]= {0,0,1,0};
		System.out.println(l.largestTimeFromDigits(A));
	}

	public String largestTimeFromDigits(int[] A) {
		
		int n = A.length;
		if (n == 0) {
			return "";
		}
		String result="";
		String r="";
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					for(int m=0;m<n;m++) {
						if(i==j||j==k||k==m||i==m||i==k||j==m)continue;
						
						String s=""+A[i]+A[j],hr=""+A[k]+A[m];
						r=s+":"+hr;
						if(s.compareTo("24")<0&&hr.compareTo("60")<0&&r.compareTo(result)>0) {
							result=r;
						}
					}
					
					
				}
			}
			
		}
		StringBuilder sb = new StringBuilder(result);
		//sb.append(start).append(hr).append(":").append(min1).append(min2);
		return sb.toString();
	}

}
