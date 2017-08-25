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
public class PermutationsII {

	public static void main(String[] args) {
		// TODO 
		int []nums=new int[]{2,2,1,1};
		permuteUnique(nums);
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer);
			}
			System.out.println();
		}
	}
	
	//11ms
	static List<List<Integer>> result = new LinkedList<>();
	public static List<List<Integer>> permuteUnique(int[] nums) {
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
		Set<Integer> done = new HashSet<>();
		for (int l = i; l < len; l++) { 
			if (i==l||nums[i]!=nums[l]) {
					if (!done.contains(nums[l])) {
						done.add(nums[l]);
						swap(nums, i, l);
						permuteRecur(nums, i+1);
						swap(nums, i, l);
					}
			}
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		// TODO 
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	//9ms
	public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;  
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
    
    //57ms
    public List<List<Integer>> permuteUnique3(int[] num) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            Set<String> cache = new HashSet<>();
            while (res.peekFirst().size() == i) {
                List<Integer> l = res.removeFirst();
                for (int j = 0; j <= l.size(); j++) {
                    List<Integer> newL = new ArrayList<>(l.subList(0,j));
                    newL.add(num[i]);
                    newL.addAll(l.subList(j,l.size()));
                    if (cache.add(newL.toString())) res.add(newL);
                }
            }
        }
        return res;
    }
    
    
    //12ms
    public List<List<Integer>> permuteUnique4(int[] nums) {
        LinkedList<List<Integer>> r = new LinkedList<>();
        r.add(new ArrayList<Integer>());
        for(int i=0; i<nums.length; i++){
            int n = r.size();
            for(int j=0; j<n; j++){
                List<Integer> list = r.poll();
                for(int k=0; k<=list.size(); k++){
                    if(k > 0 && list.get(k-1) == nums[i])
                        break;
                    ArrayList<Integer> t = new ArrayList<>(list);
                    t.add(k, nums[i]);
                    r.offer(t);
                }
            }
        }
        return r;
    }
    
    
  //11ms
//  	public  List<List<Integer>> permuteUnique5(int[] nums) {
//  		List<List<Integer>> result = new LinkedList<>();
//  		int len = nums.length;
//  		
//  		Set<Integer> done = new HashSet<>();
//  		for (int i = 0; i < nums.length; i++) {
//  			if (i==len-1) {	
//  	  			List<Integer> item = new LinkedList<>();
//  	  			for (int k = 0; k < len; k++) {
//  	  				item.add(nums[k]);
//  	  			}
//  	  			result.add(item);
//  	  		}
//  			for (int l = i; l < len; l++) { 
//  				if (i==l||nums[i]!=nums[l]) {
//  					if (!done.contains(nums[l])) {
//  						done.add(nums[l]);
//  						swap(nums, i, l);
//  						permuteRecur2(nums, i+1,result);
//  						swap(nums, i, l);
//  					}
//  				}
//  			}
//		}
//  		return result;
//      }
  	
}
