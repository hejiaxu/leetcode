package com.code.leet;
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 */
public class RangeSumQuery0303 {
    public RangeSumQuery0303(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = nums[i] + sum[i];
        }
    }
    int[] sum;

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
