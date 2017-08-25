/**
 * 
 */
package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Jiaxu
 * Jun 14, 2017
 * 
 */
public class Permutation {

	public static void main(String[] args) {
		// TODO 
		int []nums=new int[]{1,2,3,4};
		List<List<Integer>> permute6 = permute4(nums);
		for (Iterator iterator = permute6.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer);
			}
			System.out.println();
		}
	}
	
	static List<List<Integer>> result = new LinkedList<>();
	public static List<List<Integer>> permute(int[] nums) {
		permuteRecur(nums,0);
		return result;
    }
	
	private static void permuteRecur(int[] nums, int i) {
		// TODO 
		int len = nums.length;
		if (i==len-1) {
			List<Integer> item = new LinkedList<>();
			for (int k = 0; k < len; k++) {
				item.add(nums[k]);
			}
			result.add(item);
			return;
		}
		for (int l = i; l < len; l++) {
			swap(nums, i, l);
			permuteRecur(nums, i+1);
			swap(nums, i, l);
		}
	}
	
	
	
	
	public static  List<List<Integer>> permute2(int[] nums) {
  		List<List<Integer>> result = new LinkedList<>();
  		int len = nums.length;
  		
  		for (int i = 0; i < len; i++) {
  			for (int l = i+1; l < len; l++) { 
  						swap(nums, i, l);
		  	  			List<Integer> item = new LinkedList<>();
		  	  			for (int k = 0; k < len; k++) {
		  	  				item.add(nums[k]);
		  	  			}
		  	  			result.add(item);
  						swap(nums, i, l);
			}
		}
  		return result;
      }
	
	//10ms
	public static  List<List<Integer>> permute6(int[] nums) {
  		List<List<Integer>> result = new LinkedList<>();
  		int len = nums.length,sum=1;
  		for(int i=1;i<=len;i++)sum*=i;
  		for (int i = 0; i < sum; i++) {
  			List<Integer> item = new LinkedList<>();
  			for (int k = 0; k < len; k++) {
  				item.add(nums[k]);
  			}
  			result.add(item);
  			nextPermutation(nums);
		}
		return result;
		
	}
	
	public static void nextPermutation(int[] nums) {
		int len=nums.length,i = len-2;
		if (len<2) {
			return;
		}
		while(i>=0&&nums[i+1]<=nums[i])i--;
        if (i>=0) {
        	int j=i+1;
        	while(j<len&&nums[j]>nums[i])j++;
        	swap(nums,i,j-1);
		}
        reverse(nums,i+1,len-1);
    }
	private static void reverse(int[] nums, int i, int j) {
		// TODO 
		while(i<j){
			swap(nums, i, j);
			i++;
			j--;
		}
		
	}
	private static void swap(int[] nums, int i, int j) {
		// TODO 
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	//10ms
    public static List<List<Integer>> permute4(int[] nums) {
        LinkedList<List<Integer>> r = new LinkedList<>();
        r.add(new ArrayList<Integer>());
        for(int i=0; i<nums.length; i++){
            int n = r.size();
            for(int j=0; j<n; j++){
                List<Integer> list = r.poll();
                for(int k=0; k<=list.size(); k++){
                    ArrayList<Integer> t = new ArrayList<>(list);
                    t.add(k, nums[i]);
                    r.offer(t);
                }
            }
        }
        return r;
    }
    
    
  //10ms
    public static List<List<Integer>> permute3(int[] nums) {
        LinkedList<List<Integer>> r = new LinkedList<>();
        r.add(new ArrayList<Integer>());
        for(int i=0; i<nums.length; i++){
            int n = r.size();
            for(int j=0; j<n; j++){
                List<Integer> list = r.poll();
                for(int k=0; k<=list.size(); k++){
                    ArrayList<Integer> t = new ArrayList<>(list);
                    t.add(k, nums[i]);
                    r.offer(t);
                }
            }
        }
        return r;
    }
}
