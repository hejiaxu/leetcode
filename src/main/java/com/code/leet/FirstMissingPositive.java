/**
 * 
 */
package com.algorithm.leetcode;

/**
 * @author Jiaxu
 * @date Aug 17, 2016
 * @description
 * @version 1.0
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO 
//		int[] nums = {0,1,2};
		int[] nums = {-1,4,2,1,9,10};
		int num = firstMissingPositive1(nums);
		System.out.println(num);
	}
	//2ms
	public static int firstMissingPositive1(int nums[]){
		for (int i = 0; i < nums.length; i++) {
			while (nums[i]!=i+1 && nums[i] < nums.length && nums[i] > 0 && nums[i]!= nums[nums[i]-1]) {
				swap(nums, i);
			}
		}
		int j = 0;
		while (j < nums.length && nums[j] == j+1)j++;
		return j+1;
	}
	//2ms
	public int firstMissingPositive(int nums[]){
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=i+1 && nums[i] < nums.length && nums[i] > 0) {
				swap(nums, i);
			}
			i++;
		}
		for (int i = 0; i < nums.length; i++) {
				if (nums[i] != nums[nums[i]]) {
					return i;
				}
		}
		
		return -1;
	}

	private static void swap(int[] nums, int i) {
		int tmp = nums[nums[i]-1];
		nums[nums[i]-1] = nums[i];
		nums[i] = tmp;
	}

}
