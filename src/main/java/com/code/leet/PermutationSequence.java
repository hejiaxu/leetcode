/**
 * 
 */
package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Jiaxu
 * Jun 14, 2017
 * 
 */
public class PermutationSequence {

	public static void main(String[] args) {
		// TODO 
		String permutation = getPermutation3(2, 2);
		System.out.println(permutation);
	}
	
	
	//32ms
	public static String getPermutation(int n, int k) {
		StringBuilder sBuilder = new StringBuilder();
		TreeSet<Integer> set =  new TreeSet<>();
        int len = n;
        int total=1;
        for (int i = 0; i < len; i++) {
        	total*=i+1;
        	set.add(i+1);
		}
        k-=1;
        for (int j = len; j > 0 ; j--) {
        	k%=total;
        	total/=j;
			int t = k/total;
			Iterator<Integer> iterator = set.iterator(); 
			while (iterator.hasNext()&&t>=0) {
				Integer integer = (Integer) iterator.next();
				sBuilder.append(integer);
				t--;
			}
			iterator.remove();
		}
        
		return sBuilder.toString();
    }
	
	//15ms
	public static String getPermutation3(int n, int k) {
		StringBuilder sBuilder = new StringBuilder();
		//20ms
//		TreeSet<Integer> set =  new TreeSet<>();
		ArrayList<Integer> set = new ArrayList<>();
		int sum = 1;
		for (int i = 0; i < n; i++) {
			sum*=i+1;
			set.add(i+1);
		}
		getPermutationRecur2(sBuilder,set,n,(k-1)%sum,sum);
		return sBuilder.toString();
	}
	//20ms
	public static void getPermutationRecur(StringBuilder sBuilder,TreeSet<Integer> set,int n, int k, int sum) {
		int total=sum/n,t = k/total;
		Iterator<Integer> iterator = set.iterator(); 
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			if (t==0) {
				sBuilder.append(integer);
				iterator.remove();
				break;
			}
			t--;
		}
		if (n>1)getPermutationRecur(sBuilder, set, n-1, k%total, total);
    }
	public static void getPermutationRecur2(StringBuilder sBuilder,ArrayList<Integer> set,int n, int k, int sum) {
		int total=sum/n,t = k/total;
		Integer integer = set.get(t);
		sBuilder.append(integer);
		set.remove(t);
		if (n>1)getPermutationRecur2(sBuilder, set, n-1, k%total, total);
	}
	
	//17ms
	public String getPermutation2(int n, int k) {
        List<Integer> nums = new ArrayList();
        int[] factorial = new int[n+1];
        int f = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
            factorial[i] = f;
            nums.add(i);
        }
        return dfs(new StringBuilder(), nums, factorial, n, k-1);
    }
    private String dfs(StringBuilder sb, List<Integer> nums, int[] f, int n, int k) {
        if (nums.size() == 0) return sb.toString();
        int i = k/f[n-1];
        sb.append(nums.get(i));
        nums.remove(i);
        return dfs(sb, nums, f, n-1, k - i * f[n-1]);
    }
}
