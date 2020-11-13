package com.hacker;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;

		int n = s.length();

		if (n < numRows)
			return s;

		String g[] = s.split("");
		int f = numRows * 2 - 2;
		StringBuffer sb = new StringBuffer();

		for (int j = 0; j < numRows; j++) {
			for (int j2 = 0; j2 < g.length; j2++) {
				// PINALSIGYAHRPI PAHNAPLSIIGYIR
				if (j == numRows - 1) {
					j2 = j;
					j++;
				}
				if (j != 0 && j < numRows - 1) {
					int c = j2 * f + j;
					int c1 = (j2 + 1) * f - j;
					if (c < g.length) {
						sb.append(g[c]);
					} else {
						break;
					}

					if (c1 < g.length) {
						sb.append(g[c1]);

					} else {
						break;
					}

				}

				else {
					if (j == 0) {
						sb.append(g[j2]);
						j2 = f + j2 - 1;
					} else  {

						sb.append(g[j2]);
						j2 = f + j2 - 1;
					}

				}
			}

		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion zg = new ZigZagConversion();
		System.out.println(zg.convert("PAYPALISHIRING", 4));

	}

}
