package com.code.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
 */

public class L0438FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> r = new LinkedList <>();
        long hashcode = getHashcode(p);

        int plength = p.length();
        int slength = s.length();
        for (int i = 0; i < slength - plength + 1; i++) {
            String cut = s.substring(i, i + plength);
            if (getHashcode(cut) == hashcode) {
                r.add(i);
            }
        }
        return r;
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

    public static void main(String[] args) {

        List <Integer> anagrams = new L0438FindAllAnagramsinaString().findAnagrams("aa", "bb");
        for (int i = 0; i < anagrams.size(); i++) {
            Integer integer = anagrams.get(i);
            System.out.println(integer);
        }

    }
}
