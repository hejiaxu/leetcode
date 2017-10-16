package com.code.leet;

/*
Given a string containing just the characters '(' and ')',
 find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()",
 which has length = 4
 */
public class L0032LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int[][] record = new int[2][s.length()];
        int preLeft = 0;
        int max = 0;

        int numLeft = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (numLeft <= 0) {

                    record[0][i] = 0;
                } else {
                    numLeft--;
                    record[0][i] = record[0][i - 1] + 1;
                    if (preLeft > 0) {
                        record[0][i] += record[0][preLeft - 1];
                    }
                    preLeft = record[1][preLeft];
                    if (record[0][i] > max) {
                        max = record[0][i];
                    }
                }
            } else {
                if (numLeft <= 0) {
                    numLeft = 1;
                } else {
                    numLeft++;
                }
                record[1][i] = preLeft;
                preLeft = i;
            }

        }

        return max * 2;
    }

    public static void main(String[] args) {

        String s = "()(())";
        int i = new L0032LongestValidParentheses().longestValidParentheses(s);
        System.out.println(i);

    }
}
