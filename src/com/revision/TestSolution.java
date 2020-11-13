package com.revision;

//import for Scanner and other utility classes
import java.util.*;
import java.util.stream.Collectors;

class TestSolution {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		int test = s.nextInt();

		for (int i = 0; i < test; i++) {
			int k = s.nextInt();
			int n = s.nextInt();
			int arr[] = new int[k];
			int sub1[] = new int[n];
			int sub2[] = new int[n];

			for (int j = 0; j < k; j++) {
				arr[j] = s.nextInt();

			}
			for (int m = 0; m < (n); m++) {
				sub1[m] = s.nextInt();
				sub2[m] = s.nextInt();

			}
			System.out.println(operate(arr, sub1, sub2));

		}
	}

	public static int operate(int arr[], int sub1[], int[] sub2) {
		int arrLen = arr.length;
		int subLen = sub1.length;
		int alice = 0;
		int bob = 0;
		for (int i = 0; i < subLen; i++) {
			int a = sub1[i] - 1;
			int b = sub2[i] - 1;
			alice = alice +Arrays.stream(arr, a, b+1).sum();

			/*for (int j = a; j <= b; j++) {
				alice = alice + arr[j];
			}*/

		}
		Arrays.sort(arr);
		Map<Integer, Integer> mp=new HashMap<Integer, Integer>();

		int index[] = new int[arrLen];
		for (int i = 1; i <= arrLen; i++) {
			int count = 0;
			for (int j = 0; j < subLen; j++) {
				if (i >= sub1[j] && i <= sub2[j]) {
					count++;
				}
			}
			index[i - 1] = count;

		}
		int val =0;
		int len = arrLen - 1;
		int max = index[0];
		int newarr[] = new int[arrLen];
		Map<Integer, Integer> mpq=mp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
		                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		for (int i = 0; i < index.length; i++) {
			max = Integer.MIN_VALUE;
			for (int j = 0; j < index.length; j++) {
				if (index[j] > max) {
					max = index[j];
					val = j;
				}
			}
			newarr[val] = arr[len];
			len--;
			index[val] = Integer.MIN_VALUE;
		}
	
		for (int i = 0; i < subLen; i++) {
			int a = sub1[i] - 1;
			int b = sub2[i] - 1;
			bob = bob +Arrays.stream(newarr, a, b+1).sum();
		/*	for (int j = a; j <= b; j++) {
				bob = bob + newarr[j];
			}*/

		}

		return Math.abs(alice - bob);

	}
	
	
	 public int minCostII(int[][] costs) {
	        if (costs == null || costs.length == 0) {
	            return 0;
	        }
	         
	        int n = costs.length;
	        int k = costs[0].length;
	         
	        // dp[i][j] means the min cost painting for house i, with color j
	        int[][] dp = new int[n][k];
	         
	        // Initialization
	        for (int i = 0; i < k; i++) {
	            dp[0][i] = costs[0][i];
	        }
	         
	        for (int i = 1; i < n; i++) {
	            for (int j = 0; j < k; j++) {
	                dp[i][j] = Integer.MAX_VALUE;
	                for (int m = 0; m < k; m++) {
	                    if (m != j) {
	                        dp[i][j] = Math.min(dp[i - 1][m] + costs[i][j], dp[i][j]);
	                    }
	                }
	            }
	        }
	         
	        // Final state
	        int minCost = Integer.MAX_VALUE;
	        for (int i = 0; i < k; i++) {
	            minCost = Math.min(minCost, dp[n - 1][i]);
	        }
	         
	        return minCost;
	    }
}
