/**
 * 
 */
package com.code.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaxu
 * @date Aug 16, 2016
 * @description
 * @version 1.0
 */
public class ReverseVowels {

	public static void main(String[] args) {
		// TODO 
		String reverseVowels = reverseVowels("abec");
		System.out.println(reverseVowels);
	}
	static Set<String> vowels = new HashSet<>();
	
	//22ms
	public static String reverseVowels(String s){
		vowels.add("a");
		vowels.add("e");
		vowels.add("o");
		vowels.add("i");
		vowels.add("u");
		vowels.add("A");
		vowels.add("E");
		vowels.add("O");
		vowels.add("I");
		vowels.add("U");
		StringBuilder stringBuilder = new StringBuilder();
		int i = 0, j = s.length()-1;
		while(j >= 0 && i < s.length()){
			while(i < s.length() && !isVowel(s.charAt(i))){
				stringBuilder.append(s.charAt(i));
				i++;
			}
			while(j >= 0 && !isVowel(s.charAt(j))){
				j--;
			}
			if (j >= 0) {
				stringBuilder.append(s.charAt(j));
				i++;
				j--;
			}
		}
		while(i < s.length()){
			stringBuilder.append(s.charAt(i));
			i++;
		}
		while(j >= 0 && isVowel(s.charAt(j))){
			stringBuilder.append(s.charAt(j));
			j--;
		}
		return stringBuilder.toString();
	}
	
	static boolean isVowel(char c){
		if (vowels.contains(String.valueOf(c))) {
			return true;
		}
		return false;
	}
	static Set<Character> vowels2 = new HashSet<>();
	static boolean isVowel2(char c){
		if (vowels2.contains(c)) {
			return true;
		}
		return false;
	}
	
	static {
		
		vowels2.add('a');
		vowels2.add('e');
		vowels2.add('o');
		vowels2.add('i');
		vowels2.add('u');
		vowels2.add('A');
		vowels2.add('E');
		vowels2.add('O');
		vowels2.add('I');
		vowels2.add('U');
	}
	//20ms
	public static String reverseVowels2(String s){
		StringBuilder stringBuilder = new StringBuilder();
		int i = 0, j = s.length()-1;
		while(j >= 0 && i < s.length()){
			while(i < s.length() && !isVowel2(s.charAt(i))){
				stringBuilder.append(s.charAt(i));
				i++;
			}
			while(j >= 0 && !isVowel2(s.charAt(j))){
				j--;
			}
			if (j >= 0) {
				stringBuilder.append(s.charAt(j));
				i++;
				j--;
			}
		}
		while(i < s.length()){
			stringBuilder.append(s.charAt(i));
			i++;
		}
		while(j >= 0 && isVowel2(s.charAt(j))){
			stringBuilder.append(s.charAt(j));
			j--;
		}
		return stringBuilder.toString();
	}
	
	//17ms
	public static String reverseVowels3(String s){
		int length = s.length();
		char[] charArr = new char[length];
		int i = 0, j = s.length()-1, pos=0;
		while(j >= 0 && i < s.length()){
			while(i < s.length() && !isVowel2(s.charAt(i))){
				charArr[pos] = s.charAt(i);
				pos++;
				i++;
			}
			while(j >= 0 && !isVowel2(s.charAt(j))){
				j--;
			}
			if (j >= 0) {
				charArr[pos] = s.charAt(j);
				pos++;
				i++;
				j--;
			}
		}
		while(i < s.length()){
			charArr[pos] = s.charAt(i);
			i++;
			pos++;
		}
		while(j >= 0 && isVowel2(s.charAt(j))){
			charArr[pos] = s.charAt(j);
			pos++;
			j--;
		}
		return new String(charArr);
	}
	
	//isVowel4 6ms, isVowel3 7ms, isVowel2 12ms
	public static String reverseVowels4(String s){
		int length = s.length();
		char[] charArr = s.toCharArray();
		int i = 0, j = length-1;
		char tmp;
		while(i < j){
			if(isVowel2(charArr[i]) && isVowel2(charArr[j])){
			    tmp = charArr[i];
			    charArr[i] = charArr[j];
			    charArr[j]= tmp;
			    i++;
			    j--;
			}else if(!isVowel2(charArr[i])){
			    i++;
			}else j--;
		}
		return new String(charArr);
	}
	
	char[] vow = {'a','e','i','o','u','A','E','I','O','U'};
	boolean isVowel3(char c){
		for (char ch : vow) {
			if(ch == c)return true;
		}
		return false;
	}
	
	boolean isVowel4(char c){
		return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'|c=='E'||c=='I'||c=='O'||c=='U';
	}
	
	//5ms
	public String reverseVowels5(String s){
		int length = s.length();
		char[] charArr = s.toCharArray();
		int i = 0, j = length-1;
		char tmp;
		while(i < j){
			if(!isVowel4(charArr[i])){
			    i++;
			    continue;
			}
			if(!isVowel4(charArr[j])){
    			j--;
			    continue;
			}
		    tmp = charArr[i];
		    charArr[i] = charArr[j];
		    charArr[j]= tmp;
		    i++;
		    j--;
		}
		return new String(charArr);
	}
}
