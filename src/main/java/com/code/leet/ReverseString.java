/**
 * 
 */
package com.code.leet;

import javax.xml.transform.Templates;

/**
 * @author Jiaxu
 * @date Aug 16, 2016
 * @description
 * @version 1.0
 */
public class ReverseString {

	public static void main(String[] args) {
		// TODO 
		String reverseString = reverseString("abc");
		reverseString(null);
		System.out.println(reverseString);
	}
	
	//6ms
	public static String reverseString(String s){
//		if (null == s) {
//			return null;
//		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = s.length()-1; i >= 0; i--) {
			stringBuilder.append(s.charAt(i));
		}
		return stringBuilder.toString();
	}
	
	//3ms
	public String reverseString2(String s) {
        int l = s.length();
        char[] charArr = new char[l];
		for (int i = s.length()-1; i >= 0; i--) {
			charArr[l-1-i]=s.charAt(i);
		}
		return new String(charArr);
    }
	
	//4ms
	public String reverseString3(String s){
//        return new StringBuilder(s).reverse().toString();
        return new StringBuffer(s).reverse().toString();
    }
	//3ms
	public String reverseString4(String s){
		char[] charArr = s.toCharArray();
		int i = 0, j = s.length()-1;
		char tmp;
		while(i < j){
			tmp = charArr[i];
			charArr[i] = charArr[j];
			charArr[j] = tmp;
			i++;
			j--;
			
		}
		//瓶颈在这里差了1ms
		return String.valueOf(charArr);
	}
	
	//2ms
	public String reverseString5(String s){
		char[] array=s.toCharArray();
        int start = 0;
        int end = array.length-1;
        while(start<end){
            char temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
        
        return new String(array);
	}
}
