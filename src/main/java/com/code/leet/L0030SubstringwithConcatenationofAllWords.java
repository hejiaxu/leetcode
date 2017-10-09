package com.code.leet;

import java.util.*;

/*
You are given a string, s, and a list of words, words, that are all of the same length.
Find all starting indices of substring(s) in s that is a concatenation of each word in words
 exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */
public class L0030SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int[] tmp = new int[128];
        int len = 0;
        int length = s.length();
        int interval = words[0].length();

        List<Integer> r = new LinkedList <>();
        for(String word : words) {
            if ( map.containsKey(word) ) {
                Box box = map.get(word);
                box.val++;
                box.tmp++;
            } else {
                map.put(word, new Box(1,1));
            }
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                tmp[c]++;
                len ++;
            }
        }

        if (len > length) {
            return r;
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            tmp[c]--;
        }
        int left = 0;
        while(left + len <= length) {

            if ( check(s, left, interval, len, words) ) {
                    r.add(left);
                }
            if ( left + len > length - 1 ) {
                break;
            }
            char c = s.charAt(left);
            tmp[c]++;
            char c1 = s.charAt(left + len);
            left++;
            tmp[c1]--;
        }

        return r;
    }
    HashMap<String, Box> map = new LinkedHashMap<>();
    class Box {
        int val;
        int tmp;
        Box(int val, int tmp) {
            this.val = val;
            this.tmp = tmp;
        }
    }
    private boolean check(String s, int left, int interval, int len, String[] words) {
        for (Box box : map.values()) {
            box.val = box.tmp;
        }

        int pos = 0;
        while (pos < len) {
            String str = s.substring(left + pos, left + pos + interval);
            if ( !map.containsKey(str) || map.get(str).val <= 0) {
                return false;
            } else {
                Box box = map.get(str);
                box.val--;
            }
            pos += interval;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
//        String s = "barfoothefoobarman";
        String[] words = {"word","good","best","good"};
//        String[] words = {"foo","bar"};
        List <Integer> substring = new L0030SubstringwithConcatenationofAllWords().findSubstring(s, words);
        for (Integer i :
                substring) {
            System.out.println(i);
        }
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        int N = s.length();
        List<Integer> indexes = new ArrayList<Integer>(s.length());
        if (words.length == 0) {
            return indexes;
        }
        int M = words[0].length();
        if (N < M * words.length) {
            return indexes;
        }
        int last = N - M + 1;

        //map each string in words array to some index and compute target counters
        Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
        int [][] table = new int[2][words.length];
        int failures = 0, index = 0;
        for (int i = 0; i < words.length; ++i) {
            Integer mapped = mapping.get(words[i]);
            if (mapped == null) {
                ++failures;
                mapping.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int [] smapping = new int[last];
        for (int i = 0; i < last; ++i) {
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        //fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            //reset scan variables
            int currentFailures = failures; //number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / M) ==  words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return indexes;
    }

}
