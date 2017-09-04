/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 21, 2017
 * 
 */
public class SqrtX {

	public static void main(String[] args) {
		// TODO 
		int mySqrt = mySqrt(2147395599);
		System.out.println(mySqrt);
		
		
	}
	//3ms
	public static int mySqrt(int x) {
        if(x==1)return 1;
        int l=0,r=x/2;
        while(l<r){
        	long mid=(l+r)/2;
        	long pow = mid*mid;
			if (pow==x) {
				return (int)mid;
			}else if (pow<x) {
				l=(int)(mid+1);
			}else {
				r=(int)(mid-1);
			}
        }
        if (l*l>x) {
			return l-1;
		}
        return l;
    }
	
	
	
//	void qsort(int[]nums, int start, int end){
//		if (start<=end) {
//			return;
//		}
//		int pos = end,l=start,i = start;
//		for (; i < end; i++) {
//			if (nums[i]<nums[pos]) {
//				swap(nums,l++,i);
//			}
//		}
//		swap(nums, pos, i);
//		
//	}
//	private void swap(int[] nums, int i, int i2) {
//		// TODO 
//		int tmp = nums[i];
//		nums[i] = nums[i2];
//		nums[i2] = tmp;
//	}

}
