package com.hacker;

public class InterleavedStrings {

	public static void main(String[] args) {
		String s1 = "AB";
		String s2 = "CD";
		printer(s1, s2, "");
		String s3 = "c";
		System.out.println(s3.substring(0));
	}

	private static void printer(String s1, String s2, String string) {
		// TODO Auto-generated method stub

		if (s1 == null) {
			System.out.println(s1);
		}
		if (s2 == null) {
			System.out.println(s2);
		}

		if (s1.length() == 0 && s2.length() == 0) {
			System.out.println(string);

		}
		if (s1.length() != 0) {
			printer(s1.substring(1), s2, string + s1.charAt(0));

		}
		if (s2.length() != 0) {
			printer(s1, s2.substring(1), string + s2.charAt(0));

		}

	}

}
