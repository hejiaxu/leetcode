package com.code.misc;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s = "abccedd";
        String t = "cceb";
        int lcs = new LongestCommonSubstring().kmp(s, t);
        System.out.println(lcs);
    }


    int kmp(String s, String t) {
        int[] next = new int[t.length()];
        next[0] = -1;
        for (int i = 1; i < t.length(); i++) {
            int j = next[i - 1];
            while (j != -1 && t.charAt(i - 1) != t.charAt(j)) {
                j = next[j];
            }
            next[i] = j + 1;
        }

        int j = 0;
        int k = 0;
        int max = 0;
        while(j < s.length()) {
            if (k == t.length()) {
                return k;
            }
            if (k == -1 || t.charAt(k) == s.charAt(j)) {
                k++;
                j++;
                max = max> k ? max : k;
            } else {
                k = next[k];
            }
        }
        return max;
    }
}
