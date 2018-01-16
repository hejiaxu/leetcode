/**
 * 
 */
package com.code.leet;

/**

 Implement int sqrt(int x).

 Compute and return the square root of x.

 x is guaranteed to be a non-negative integer.
 */
public class L0069SqrtX {

	public static void main(String[] args) {
		// TODO 
		int mySqrt = new L0069SqrtX().mySqrt2(36);
		System.out.println(mySqrt);
		
		
	}
	//3ms
	public int mySqrt(int x) {
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

    //46ms
	int mySqrt2(int x) {
		double yp = x + 0.25, yn;
		for (; ; ) {
			yn = (yp * yp + x) / (2 * yp);
			if (Math.abs(yn - yp) <= 0.1) break;
			yp = yn;
		}
		return (int) yn;

	}
}
