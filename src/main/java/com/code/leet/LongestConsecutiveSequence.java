/**
 * 
 */
package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Jiaxu
 * Jun 26, 2017
 * 
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
//		int[] nums = new int []{0,-1};
//		int[] nums = new int []{100, 4, 200, 1, 3, 2};
		int[] nums = new int []{0,0};
//		int longestConsecutive = longestConsecutive(nums);
//		System.out.println(longestConsecutive);
		int[] longestConsecutive2 = longestConsecutive2(nums);
		System.out.println(Arrays.toString(longestConsecutive2));
	}
	public static int longestConsecutive(int[] nums) {
		if (nums==null||nums.length==0) {
			return 0;
		}
		Arrays.sort(nums);
		int ml=0,mr=1,l=0,r=1;
		while(r<nums.length){
			if (nums[r]==nums[r-1]) {
				l++;
			}else if(nums[r]!=nums[r-1]+1){
				if(r-l>mr-ml){
					mr=r;
					ml=l;
				}
				l=r;
			}
			r++;
		}
		if(r-l>mr-ml){
			mr=r;
			ml=l;
		}
		return mr-ml;
    }
	
	//4ms
	public static int[] longestConsecutive2(int[] nums) {
		if (nums==null||nums.length==0) {
			return nums;
		}
		Arrays.sort(nums);
		int ml=0,mr=1,l=0,r=1;
		while(r<nums.length){
			if (nums[r]==nums[r-1]) {
				l++;
			}else if(nums[r]!=nums[r-1]+1){
				if(r-l>mr-ml){
					mr=r;
					ml=l;
				}
				l=r;
			}
			r++;
		}
		if(r-l>mr-ml){
			mr=r;
			ml=l;
		}
		return Arrays.copyOfRange(nums, ml, mr);
	}
	
	public int longestConsecutive3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
    
    Set<Integer> set = new HashSet<Integer>();
    
    for(int num: nums) set.add(num);
    int max = 1;
    for(int num: nums) {
        if(set.remove(num)) {//num hasn't been visited
            int val = num;
            int sum = 1;
            while(set.remove(val-1)) val--;
            sum += num - val;
            
            val = num;
            while(set.remove(val+1)) val++;
            sum += val - num;
            
            max = Math.max(max, sum);
        }
    }
    return max;
    }

}
