package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRomans {
	public static void main(String[] args) {
		IntegerToRomans r = new IntegerToRomans();
		System.out.println(r.intToRoman(6));
	}

	Map<Integer, String> mp;

	public String intToRoman(int num) {
		if(num<1||num>3999) {
			return "";
		}
		mp = new HashMap<>();
		mp.put(1, "I");
		mp.put(5, "V");
		mp.put(10, "X");
		mp.put(50, "L");
		mp.put(100, "C");
		mp.put(500, "D");
		mp.put(1000, "M");

		if (mp.get(num) != null) {
			return mp.get(num);

		}
		int mult = 1;
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			int res = num % 10;
			res = res * mult;
			if(res>0)
			numberChange(res, mult, sb);
			mult = mult * 10;
			num = num / 10;
		}
		return sb.toString();

	}

	public void numberChange(int res, int digit, StringBuilder sb) {
		if (mp.get(res) != null) {
			sb.insert(0, mp.get(res));
		} else if (mp.get(res + digit)!=null) {
			sb.insert(0, (mp.get(digit).concat(mp.get(res+digit))));

		}
		
		else {
			int n = res / digit;
			int nm=res>digit*5?(res-digit*5):res;
			if(nm!=res) {
				for (int i = 0; i < nm/digit; i++) {
					sb.insert(0, mp.get(digit));
				}
				sb.insert(0,mp.get(digit*5));
			}
			else {
				for (int i = 0; i < n; i++) {
					sb.insert(0, mp.get(digit));

				}
			}
			
		}

	}

	/*
	 * public static final Map<Integer, String> map = new HashMap<Integer, String>()
	 * { { put(1, "I"); put(5, "V"); put(10, "X"); put(50, "L"); put(100, "C");
	 * put(500, "D"); put(1000, "M"); } };
	 * 
	 * public static String intToRoman(int num) { StringBuilder res = new
	 * StringBuilder(); int digit = 1;
	 * 
	 * while (num > 0) { int number = (num % 10) * digit; if (number == 0) { num /=
	 * 10; digit *= 10; continue; } if (map.containsKey(number)) { res.insert(0,
	 * map.get(number)); } else if (map.containsKey(number + digit)) { res.insert(0,
	 * map.get(digit).concat(map.get(number + digit))); } else { int n = number >
	 * digit * 5 ? (number - digit * 5) : number; for (int i = 0; i < n / digit;
	 * i++) { res.insert(0, map.get(digit)); }
	 * 
	 * if (n != number) { res.insert(0, map.get(digit * 5)); } } num /= 10; digit *=
	 * 10; }
	 * 
	 * return res.toString(); }
	 */
}
