/**
 * 
 */
package com.code.leet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Jiaxu
 * Jun 15, 2017
 * 
 */
public class Combinations {

	public static void main(String[] args) {
		// TODO 
		List<List<Integer>> combine = combine(4, 2);
		for (Iterator iterator = combine.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer);
			}
			System.out.println();
		}
	}
	
	//13ms
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new LinkedList<>();
		result.add(new LinkedList<Integer>());
		combineRecur(result,n,k);
		return result;
    }

	private static void combineRecur(List<List<Integer>> result, int n, int k) {
		if (k==0||n<k) {
			return;
		}
		List<List<Integer>> result2 = new LinkedList<>();
		if (n>k) {
			for (Iterator iterator = result.iterator(); iterator.hasNext();) {
				List<Integer> list = (List<Integer>) iterator.next();
				List<Integer> item = new LinkedList<>();
				for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
					Integer integer = (Integer) iterator2.next();
					item.add(integer);
				}
				result2.add(item);
			}
		}
		combineRecur(result,n-1,k-1);
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			list.add(n);
		}
			
		if (n>k) {
			combineRecur(result2,n-1,k);
			result.addAll(result2);
		}
	}
	
	//12ms
	public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }
	
	//12ms
	public List<List<Integer>> combine3(int n, int k) {
        List<List<Integer>> ans = new LinkedList();
        if (n < k || k == 0) return ans;

        ans = combine(n-1, k-1);
        //if at this point ans is empty, it can only be that k-1 == 0, 
        //n-1<k-1 is not possible since n>=k (if n<k, the function would have already returned at an early point)
        if (ans.isEmpty()) ans.add(new LinkedList<Integer>());
        for (List<Integer> list:ans) list.add(n);
        
        ans.addAll(combine(n-1, k));
        return ans;
    }
}
