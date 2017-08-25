/**
 * 
 */
package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Jiaxu
 * Oct 20, 2016
 * 
 */
public class CountingBits {

	public static void main(String[] args) {
		// TODO 
		CountingBits bean = new CountingBits();
		int[] countBits = bean.countBits(15);
		for (int i = 0; i < countBits.length; i++) {
			System.out.println(countBits[i]);
		}
		
	}
	
	//3ms
	public int[] countBits(int num) {
		int [] result = new int[num+1];
		if (num <= 0) {
			return result;
		}
		result[0] = 0;
		int j=0,shift=1;
		while(shift<=num){
			j=0;
			while(j<shift&&shift+j<=num){
				result[shift+j]=result[j] + 1;
				j++;
			}
			shift *= 2;
		}
        
        return result;
    }
}
