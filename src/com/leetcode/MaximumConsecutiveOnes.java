package com.leetcode;

import java.util.LinkedHashSet;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        LinkedHashSet<Character> set=new LinkedHashSet<>();
        set.add('c');
        set.add('y');
        char f= set.iterator().next();
        MaximumConsecutiveOnes m=new MaximumConsecutiveOnes();
        m.longestOnes(new int[]{1,1,1,1,0,0,0,1,1,1,0,0,1,1},2);
    }
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int max = 0;

        int numZeroes = 0;
        for (right= 0; right<A.length; right++) {

            if (A[right]==0) numZeroes++;

            if (numZeroes > K) {
                if (A[left]==0) numZeroes--;
                left ++;
            }
            if (numZeroes <= K) {
                // this is probably what I could come up during interview...
                max = Math.max(max, right-left +1 );
            }
        }
        return max;
    }
}
