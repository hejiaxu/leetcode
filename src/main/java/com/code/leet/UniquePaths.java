/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 26, 2017
 * 
 */
public class UniquePaths {

	public static void main(String[] args) {
		// TODO 
		int uniquePaths = uniquePaths2(23, 12);
		System.out.println(uniquePaths);
	}
	//TLE
	public static int uniquePaths(int m, int n) {
        if (m==1||n==1) {
			return 1;
		}
        return uniquePaths(m-1, n)+uniquePaths(m, n-1);
    }
	
	//0ms
	public static int uniquePaths2(int m, int n) {
		if (m>n) return uniquePaths2(n, m);
		int[] tmp = new int[m];
		tmp[0]=1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				tmp[j]+=tmp[j-1];
			}
		}
		return tmp[m-1];
	}
	
	//0ms
	public static int uniquePaths3(int m, int n) {
		if (m>n) return uniquePaths3(n, m);
		double result=1;
		for (int i = 1; i < m; i++) {
//			int N = n+m-2;
//			result= result*(N-i+1)/i;
			result= result*(n-1+i)/i;
		}
		return (int)result;
	}

}
