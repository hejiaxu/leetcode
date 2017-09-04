/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * May 10, 2017
 * 
 */
public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO 
		
//		int [] nums1 = {1,1,1},nums2 = {1,1,1};
		int [] nums1 = {2},nums2 = {1,3,4};
		
//		int [] nums1 = {3,4},nums2 = {1,2};
//		int [] nums1 = {3},nums2 = {1,2};
		double l = findMedianSortedArrays(nums1, nums2);
		System.out.println(l);
	}
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int m = nums1.length,n=nums2.length;
		int a = (m+n+1)/2;
		int b = (m+n+2)/2;
		return (findKth(nums1, 0, m, nums2, 0, n, a)+ findKth(nums1, 0, m, nums2, 0, n, b))/2.0;
	}
	
	
	public static int findKth(int []s,int sStart,int sEnd,int[]t,int tStart,int tEnd,int k){
		if (tEnd-tStart>sEnd-sStart) {
			return findKth(t, tStart, tEnd, s, sStart, sEnd, k);
		}
		if (tEnd-tStart==0) {
			return s[sStart+k-1];
		}
		if (k==1) {
			return Math.min(s[sStart], t[tStart]);
		}
		int ti=Math.min(tEnd-tStart, k/2);
		if (s[sStart+ti-1]>=t[tStart+ti-1]) {
			return findKth(s, sStart, sEnd, t, tStart+ti, tEnd, k-ti);
		}
		
		return findKth(s, sStart+ti, sEnd, t, tStart, tEnd, k-ti);
	}
//    
//    double findMedianSortedArrays(int A[], int m, int B[], int n) {
//        int l = (m + n + 1) >> 1;
//        int r = (m + n + 2) >> 1;
//        return (getkth(A, m ,B, n, l) + getkth(A, m, B, n, r)) / 2.0;
//    }
//	
}
