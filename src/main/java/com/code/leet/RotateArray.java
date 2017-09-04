/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 8, 2017
 * 
 */
public class RotateArray {

	public static void main(String[] args) {
		// TODO 
		int nums[] = new int[]{1,2,3};
//		int nums[] = new int[]{1,3,4,5,7,8,11};
		rotate2(nums, 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	//1ms
	public  static void rotate(int[] nums, int k) {
		int[] nums2 = new int[nums.length];
		System.arraycopy(nums, 0, nums2,0,nums.length);
		for (int i = 0; i < nums2.length; i++) {
			nums[(i+k)%nums.length]=nums2[i];
		}		
    }
	
	
	public static void rotate2(int []nums,int k){
		k%=nums.length;
		reverse(nums, 0, k);
		reverse(nums, k, nums.length);
		reverse(nums, 0, nums.length);
	}
	
	public static void reverse(int[]nums,int start, int length){
		int end =length-1;
		int tmp;
		while(start<end){
			tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}

}
