/**
 * 
 */
package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Jiaxu
 * Apr 20, 2017
 * 
 */
public class ContainsDuplicateIII {

	public static void main(String[] args) {

		int[] a = {-3,3};
		boolean containsNearbyAlmostDuplicate4 = containsNearbyAlmostDuplicate3(a, 2, 4);
		System.out.println(containsNearbyAlmostDuplicate4);
	}
	
	
	
	//TLE
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		Set<Integer> set = new HashSet<>();
		int j=0;
		for (int i = 0; i < nums.length; i++) {
			if (j<i-k) {
				set.remove(nums[j]);
				j++;
			}
			for(int l=nums[i]-t;l<=nums[i]+t;l++){
				if (set.contains(l)) {
					return true;
				}
			}
			set.add(nums[i]);
		}
		
		return false;
    }
	
	//TLE
	public static boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
		Set<Long> set = new HashSet<>();
		int j=0;
		for (int i = 0; i < nums.length; i++) {
			if (j<i-k) {
				set.remove((long)nums[j]);
				j++;
			}
			
			for (Long integer : set) {
				if(Math.abs(integer-nums[i])<=t)return true;
			}
			set.add((long)nums[i]);
		}
		
		return false;
	}
	//58ms O(N*log(k))
	public static boolean containsNearbyAlmostDuplicate4(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			long tmp = (long)nums[i];
			if (i>k) {
				set.remove((long)nums[i-k]);
			}
			Long ceil = set.ceiling(tmp);
			if (ceil!=null&&ceil-tmp<=t) {
				return true;
			}
			Long floor = set.floor(tmp);
			if (floor!=null&&tmp-floor<=t) {
				return true;
			}
			set.add(tmp);
		}
		
		return false;
	}
	//28ms O(N)
	public boolean containsNearbyAlmostDuplicate5(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
	
}
