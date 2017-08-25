/**
 * 
 */
package com.algorithm.leetcode;

/**
Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 */
public class CountOfRangeSum {

	public static void main(String[] args) {
		// TODO 
		CountOfRangeSum bean = new CountOfRangeSum();
		int[] nums = new int[]{2147483647,-2147483648,-1,0};
		int result = bean.countRangeSum(nums, -1, 0);
		System.out.println(result);
	}
	//Time Limit Exceeded
	public int countRangeSum(int[] nums, int lower, int upper) {
		int length = nums.length,count = 0;
        long []tmp = new long[length];
        for (int i = 0; i < tmp.length; i++) {
        	tmp[i] = nums[i];
        }
        for (int i = 0; i < tmp.length; i++) {
        	for (int j = tmp.length-1; j >= i; j--) {
        		if (tmp[j]<=upper&&tmp[j]>=lower) {
        			count++;
        		}
        		if (j>0) {
        			tmp[j] = nums[j] + tmp[j-1];
        		}
        	}
        	
        }
        return count;
    }
	
	public int countRangeSum2(int[] nums, int lower, int upper) {
		int count = 0;
        return count;
    }
	
	//17ms
	public int countRangeSum3(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    return countWhileMergeSort(sums, 0, n + 1, lower, upper);
	}

	private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
	    if (end - start <= 1) return 0;
	    int mid = (start + end) / 2;
	    int count = countWhileMergeSort(sums, start, mid, lower, upper) 
	              + countWhileMergeSort(sums, mid, end, lower, upper);
	    int j = mid, k = mid, t = mid;
	    long[] cache = new long[end - start];
	    for (int i = start, r = 0; i < mid; ++i, ++r) {
	        while (k < end && sums[k] - sums[i] < lower) k++;
	        while (j < end && sums[j] - sums[i] <= upper) j++;
	        while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
	        cache[r] = sums[i]; 
	        count += j - k;
	    }
	    System.arraycopy(cache, 0, sums, start, t - start);
	    return count;
	}
}
