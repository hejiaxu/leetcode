/**
 * 
 */
package com.algorithm.leetcode;

/**
 * Jiaxu
 * Jun 22, 2017
 * 
 */
public class TwoSum {
	public static void main(String[] args) {
		int []nums = new int[]{-2,-1,0,1,2,4};
		int[] twoSum = twoSum(nums, 3);
		for (int i : twoSum) {
			System.out.print(i);
		}
	}
	public static int[] twoSum(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<r){
        	if (nums[l]+nums[r]==target) {
				break;
			}else if (nums[l]+nums[r]>target) {
				int start=l+1,end=r-1;
				int mid = start;
				while(start<end){
					mid = (start+end)/2;
					if (nums[mid] ==target-nums[l]) {
						break;
					}else if (nums[mid] >target-nums[l]) {
						end=mid-1;
					}else {
						start=mid+1;
					}
				}
				r=mid;
			}else {
				int start=l+1,end=r-1;
				int mid = start;
				while(start<end){
					mid = (start+end)/2;
					if (nums[mid]==target-nums[r]) {
						break;
					}else if (nums[mid]>target-nums[r]){
						end=mid-1;
					}else {
						start=mid+1;
					}
				}
				l=mid;
			}
        }
        return new int[]{nums[l],nums[r]};
        
    }
	
	int oneSum(int[]nums,int start,int end, int target){
		int mid = start;
		while(start<end){
			mid = (start+end)/2;
			if (nums[mid] ==target) {
				break;
			}else if (nums[mid] >target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return mid;
	}
}
