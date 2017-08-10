package leet;

import java.util.HashMap;

/*
https://leetcode.com/problems/subarray-sum-equals-k/tabs/description
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class SubarraySumEqualsK0560 {

    //36ms
    public int subarraySum(int[] nums, int k) {
        int num = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<nums.length;i++)nums[i]+=nums[i-1];
        for(int i=0;i<nums.length;i++){
            if (nums[i]==k)num++;
            if (map.containsKey(nums[i]-k))num+=map.get(nums[i]-k);
            if (map.containsKey(nums[i]))map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        return num;
    }
}
