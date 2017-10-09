/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Sep 23, 2016
 * 
 */
public class AddDigits {
	public static void main(String argv[]){
		int addDigits = addDigits(34555);
		System.out.println(addDigits);
	}
	//2ms
	public static int addDigits(int num){
		int result = 0;
		while(num > 0){
			result += num%10;
			num = num/10;
			if (result > 9) {
				result = result%10 + 1;
			}
		}
		return result;
	}
	//2ms
	public static int addDigits2(int num){
		return (1+(num-1)%9);
	}
	//2ms
	public static int addDigits3(int num){
		return (num!=0&&num%9==0)?9:num - 9*(num/9);
	}
	//2ms
	public static int addDigits4(int num){
		return (num!=0&&num%9==0)?9:num%9;
	}
}
