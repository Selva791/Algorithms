package com.leetcode;

public class SolveTheEquation {
	public static void main(String[] args) {
		SolveTheEquation s=new SolveTheEquation();
		System.out.println(s.solveEquation("x-10=10-x+x+2x"));
	}
	public String solveEquation(String equation) {
		// Map<Character,Integer> mp=new HashMap<>();
		int n = equation.length();
		int count = 0;
		int sign = 1;
		int eq = 1;
		int number = 0;
		int x = 0;
		char prev='a';
		for (int i = 0; i < n; i++) {
			char temp = equation.charAt(i);
			if (Character.isDigit(temp)) {
				count = count * 10 + temp - '0';
				prev=(char) (count+'0');
			} else if (temp == '=') {
				number += eq * sign * count;
				eq = -1;
				sign=1;
				count=0;
			} else if (temp == '-') {
				number += eq * sign * count;
				sign = -1;
				count = 0;

			} else if (temp == '+') {
				number += eq * sign * count;
				sign = 1;
				count = 0;
			} else if (temp == 'x') {

				if (count > 0)
					x+= eq*sign * count;
				else if(count==0&&prev=='0')
					x=0;
				else
					x +=eq* sign*1;
				
				count = 0;

			}
		}
		number=number+(eq*sign*count);
		if (x >0) {
			 number=-1*number;
			 
			return "x=" + (number/x);
		}else if (x == 0 && number == 0) {
			return "Infinite solutions";
		}
		else if (x == 0) {
			return "No solution";
		}  else if (x ==-1) {
			return "x=" + (1 * number);
		}else if(x<-1){
            x=-1*x;
           // number=-1*number;
            int a=number/x;
            return "x="+a;
        }
		System.out.println(number + " " + x);
		return "";
	}
}
