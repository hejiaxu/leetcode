/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Apr 14, 2017
 * 
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO 
		boolean isomorphic = isIsomorphic("baa", "cfa");
		System.out.println(isomorphic);
	}
	//3ms
	public static boolean isIsomorphic(String s, String t) {
		char tmp[] = new char [128];
		
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		for (int i = 0; i < sChar.length; i++) {
			char ci = sChar[i];
			char ti = tChar[i];
			if (tmp[ti]==0) {
				tmp[ti]=ci;
			}else if (tmp[ti]!=ci) {
				return false;
			}
		}
		for (int i = 1; i < tmp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (tmp[i]==tmp[j]&&tmp[i]!=0) {
					return false;
				}
				
			}
		}
		return true;
	}
	//10ms
	public boolean isIsomorphic2(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
	//5ms ??
	public boolean isIsomorphic3(String s1, String s2) {
		int[] m = new int[256];
		char[] s1Char = s1.toCharArray();
		char[] s2Char = s2.toCharArray();
		for (int i = 0; i < s1.length(); i++) {
			if (m[s1Char[i]] != m[s2Char[i]+128]) return false;
			m[s1Char[i]] = m[s2Char[i]+128] = i+1;
		}
		return true;
	}
}
