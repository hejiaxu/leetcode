/**
 * 
 */
package com.code.leet;

import java.util.LinkedList;
import java.util.List;

/**
 * Jiaxu
 * Jun 21, 2017
 * 
 */
public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		// TODO 
		List<String> letterCombinations = letterCombinations2("2");
		for (String string : letterCombinations) {
			System.out.println(string);
		}
	}
	
	//6ms
    public static List<String> letterCombinations(String digits) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> r = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            if(r.isEmpty())r.add(new String());
			int j=digits.charAt(i)-'0';
			List<List<String>> lists = new LinkedList<>();
			for (int k = 0; k < mapping[j].length(); k++) {
				List<String> list = new LinkedList<>();
				for (String item : r) {
					list.add(item+mapping[j].charAt(k));
				}
				lists.add(list);
			}
			r.removeAll(r);
			for (List<String> list : lists) {
				r.addAll(list);
			}
		}
        return r;
    }
    
  //6ms
    public static List<String> letterCombinations2(String digits) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits==null) {
			return null;
		}
        List<String> dfs = dfs(digits,0,mapping);
        return dfs;
    }
    
    public static List<String> dfs(String digits, int pos, String[] mapping){
    	if (pos==digits.length()) {
			return new LinkedList<>();
		}
    	List<String> r = new LinkedList<>();
    	for(int i=0;i<mapping[digits.charAt(pos)-'0'].length();i++) {
			List<String> dfs = dfs(digits, pos+1,mapping);
			if (dfs.isEmpty()) {
				dfs.add("");
			}
			for (String string : dfs) {
				r.add(mapping[digits.charAt(pos)-'0'].charAt(i)+string);
			}
		}
    	return r;
    	
    }
}
