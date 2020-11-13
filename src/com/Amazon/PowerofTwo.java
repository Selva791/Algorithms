package com.Amazon;

public class PowerofTwo {
	public static void main(String[] args) {
		PowerofTwo p=new PowerofTwo();
		System.out.println(p.calculate(25));
		
	}

		public boolean calculate(int s) {
			
			while(s!=1) {
				
				if(s%2!=0) {
					return false;
				}
				s=s/2;
				
			}
			return true;
			
		}
}
