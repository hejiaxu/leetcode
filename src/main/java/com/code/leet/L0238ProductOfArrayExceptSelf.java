package com.code.leet;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 */
public class L0238ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] r = new int[nums.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = 1;
        }
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            r[i] *= left;
            left *= nums[i];
            r[nums.length - 1 - i] *= right;
            right *= nums[nums.length - 1 - i];
        }
        return r;
    }
}

// 第i个位置为 (i-1)! * n! / i!，累积乘积，从左向右和从右向左来两次。