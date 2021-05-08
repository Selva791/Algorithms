package com.leetcode;

public class VerifyPreorderSerializationofaBinaryTree {
	public static void main(String[] args) {
		VerifyPreorderSerializationofaBinaryTree v=new VerifyPreorderSerializationofaBinaryTree();
		System.out.println(v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}

	public boolean isValidSerialization(String preorder) {
		char c[] = preorder.toCharArray();
		return isValid(c, c.length);
	}

	public boolean isValid(char c[], int n) {
		int count = 0, total = 0;
		int i = 0;
		while (i < n) {
			if(c[i]==',') {
				i++;
				continue;
			}
			
			int b = 0;
			
			if (c[i] == '#') {
				while (i < n && (c[i] == '#'||c[i]==',')) {
					if(c[i]=='#') {
						b++;
						total++;
					}
					i++;
				}
			} else {
				i++;
				count++;
			}
			if (b > 2) {
				return false;
			}

		}
		if (total <= count) {
			return false;
		}
		return true;
	}
}
