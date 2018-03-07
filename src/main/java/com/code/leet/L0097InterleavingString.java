package com.code.leet;

/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */
public class L0097InterleavingString {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        String s3 = "a";
        boolean interleave = new L0097InterleavingString().isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        return dfs(s1, 0, s2, 0, s3, 0, new boolean[s1.length() + 1][s2.length() + 1]);
    }

    public boolean dfs(String s1, int p1, String s2, int p2, String s3, int p3, boolean[][] visited) {
        if (s1.length() == p1 && s2.length() == p2 && s3.length() == p3) {
            return true;
        }
        if (visited[p1][p2] == true) {
            return false;
        }
        visited[p1][p2] = true;
        return  p3 < s3.length() && ((p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3) && dfs(s1, p1 + 1, s2, p2, s3, p3 + 1, visited))
                || (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3) && dfs(s1, p1, s2, p2 + 1, s3, p3 + 1, visited)));
     }
}