/**
 * 
 */
package com.algorithm.leetcode;

/**
 * Jiaxu
 * Apr 18, 2017
 * 
 */
public class PerfectNumber {

	public static void main(String[] args) {
		// TODO 
		boolean checkPerfectNumber = checkPerfectNumber2(28);
		System.out.println(checkPerfectNumber);
	}
	//TLE
	public static boolean checkPerfectNumber(int num) {
		if (num==1) {
			return false;
		}
        int result = 0;
		for(int i=1;i<num;i++){
        	if (num%i==0) {
				result+=i;
			}
        }
		
		return result==num;
    }
	
	//13ms
	public static boolean checkPerfectNumber2(int num) {
		if (num==1) {
			return false;
		}
		int result = 1;
		for(int i=2;i<Math.sqrt(num);i++){
			if (num%i==0) {
				result+=i+num/i;
			}
		}
		return result==num;
	}
}
