/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Mar 29, 2017
 * 
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO 
//		int divide = divide3(10,3);
//		int divide = divide3(-2147483648,-1);
//		int divide = divide3(2147483647,1);
		int divide = divide4(2147483647,3);
		System.out.println(divide);
	}
	//TLE
	public static int divide(int dividend, int divisor) {
		long dd =dividend,dr = divisor;
		if (dr==0) {
			return Integer.MAX_VALUE;
		}
		long result = 0;
		boolean sign = false;
		if (dd<0) {
			sign=!sign;
			dd = 0-dd;
		}
		if (dr<0) {
			sign=!sign;
			dr= 0- dr;
		}
		while(dd>=dr){
			dd-=dr;
			result++;
		}
		if (sign) {
			result = 0 - result;
		}
		if (result>Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}
        return (int)result;
    }
	
	//TLE
	public static int divide2(int dividend, int divisor) {
		long dd =dividend,dr = divisor;
		if (dr==0) {
			return Integer.MAX_VALUE;
		}
		long result = 0;
		boolean sign = false;
		if (dd<0) {
			sign=!sign;
			dd = 0-dd;
		}
		if (dr<0) {
			sign=!sign;
			dr= 0- dr;
		}           
		result = divide2(dd, dr);
		if (sign) {
			result = 0 - result;
		}
		if (result>Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}
        return (int)result;
	}
	public static long divide2(long dividend, long divisor) {
		int result = 0;
		while(dividend>=divisor){
			dividend-=divisor;
			result++;
		}                                                                                                                                                                                                                                      
		return result;
	}
	
	public static long divide4(long dividend, long divisor) {
		long tempDivisor = divisor,result=0;
        while(tempDivisor<<1<=dividend)tempDivisor= tempDivisor<<1;
        while(tempDivisor>=divisor){
            result=result<<1;
            if(dividend>=tempDivisor){
                dividend-=tempDivisor;
                result++;
            }
            tempDivisor=tempDivisor>>1;
        }
        
        return result;
	}

	
	//41ms
	public static int divide3(int dividend, int divisor) {
		long dd =dividend,dr = divisor;
		if (dr==0) {
			return Integer.MAX_VALUE;
		}
		long result = 0;
		boolean sign = false;
		if (dd<0) {
			sign=!sign;
			dd = 0-dd;
		}
		if (dr<0) {
			sign=!sign;
			dr= 0- dr;
		}           
		result = divide3(dd, dr);
		if (sign) {
			result = 0 - result;
		}
		if (result>Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}
		return (int)result;
	}
	public static long divide3(long dividend, long divisor) {
		long sum = 0,tmp=1,tmpDivisor=divisor;
		
		if (dividend<tmpDivisor) {
			return 0;
		}else if (dividend<tmpDivisor+tmpDivisor) {
			return 1;
		}else {
			while(tmpDivisor<<1<dividend){
				tmpDivisor=tmpDivisor<<1;
				tmp=tmp<<1;
			}
			while(tmpDivisor>=divisor){
				if (dividend>=tmpDivisor) {
					sum+=tmp;
					dividend-=tmpDivisor;
				}else{
					tmpDivisor=tmpDivisor>>1;
					tmp=tmp>>1;

				}
			}
			dividend -=tmpDivisor;
			return sum;
		}                                                                                                                                                                                                                        
	}
	
	//51ms
	public static int divide4(int dividend, int divisor) {
		long dd =dividend,dr = divisor;
		if (dr==0) {
			return Integer.MAX_VALUE;
		}
		long result = 0;
		boolean sign = false;
		if (dd<0) {
			sign=!sign;
			dd = 0-dd;
		}
		if (dr<0) {
			sign=!sign;
			dr= 0- dr;
		}           
		long tmp=1,tmpDivisor=dr;

		while(tmpDivisor<<1<=dd){
			tmpDivisor=tmpDivisor<<1;
			tmp=tmp<<1;
		}
		result = divide4(dd, tmpDivisor,tmp);
		if (sign) {
			result = 0 - result;
		}
		if (result>Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}
		
		return (int)result;
	}
	public static long divide4(long dividend, long tmpDivisor,long tmp) {
		
		if (tmp<=0) {
			return 0;
		}else if (dividend<tmpDivisor) {
			return divide4(dividend,tmpDivisor>>1,tmp>>1);
		}else{
			return tmp + divide4(dividend-tmpDivisor,tmpDivisor>>1,tmp>>1);
		}                                                                                                                                                                                                                        
	}

	
}
