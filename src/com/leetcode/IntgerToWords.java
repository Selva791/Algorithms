package com.leetcode;

public class IntgerToWords {
	public static void main(String[] args) {
		IntgerToWords w=new IntgerToWords();
		System.out.println(w.numberToWords(122564009));
	}

	String tens[] = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	String ones[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

	String hundreds[] = { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";

		if (num == 1)
			return "One";
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			int rem = num % 1000;
			num = num / 1000;

			sb = wordsOfNum(rem,i).append(" ").append(sb.toString());

			i++;
		}
		return sb.toString().trim();
	}

	public StringBuilder wordsOfNum(int val,int i) {
		StringBuilder sb = new StringBuilder();
		while (val > 0) {
			if (val >= 10 && val < 20) {
				sb.append(ones[val]).append(" ");
				break;
			}
			if ((val / 100) > 0) {
				int v = val / 100;
				sb.append(ones[v]).append(" ").append("Hundred").append(" ");
				val = val % 100;
			} else if (val / 10 > 0) {
				int v = val / 10;
				sb.append(tens[v]).append(" ");
				val = val % 10;
			} else if(val>0){
				sb.append(ones[val]).append(" ");
				val = val / 10;
			}

		}
		if(sb.length()>0) {
			sb.append(hundreds[i]);
		}
		return sb;
	}
}
