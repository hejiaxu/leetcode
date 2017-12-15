package com.code.leet;

/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class L0242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (getHashcode(s) == getHashcode(t)) {
            return true;
        }
        return false;
    }
    private long getHashcode(String str) {
        long add = 0;
        long multiply = 1;
        long xor = 1;
        for (int i = 0; i < str.length(); i++) {
            add += str.charAt(i);
            multiply *= str.charAt(i) * (str.charAt(i) + 'a');
            xor ^= str.charAt(i);
        }

        return add ^ multiply ^ xor;
    }
}
