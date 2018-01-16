package com.code.leet;

public class L0091DecodeWays {

    //TLE
    public int numDecodings2(String s) {
        int count = 0;
        if (s.length() < 1) {
            return count;
        }

        if (isUpperCase(s.charAt(0))) {
            if (s.length() == 1) return 1;
            count += numDecodings2(s.substring(1));
        }

        if (s.length() > 1 && isUpperCase(s.charAt(0), s.charAt(1))) {
            if (s.length() == 2) return count + 1;
            count += numDecodings2(s.substring(2));
        }

        return count;
    }

    private boolean isUpperCase(char c, char c1) {
        if (1 == c - '0' && 9 >= c1 - '0' && 0 <= c - '0'
                || 2 == c - '0' && 6 >= c1 - '0' && 0 <= c - '0'
                ) {
            return true;
        }
        return false;
    }

    private boolean isUpperCase(char c) {
        return 1 <= c - '0' && 9 >= c - '0';
    }


    public int numDecodings(String s) {
        int length = s.length();
        if ( length < 1) {
            return 0;
        }
        int[] record = new int[length];

        for (int i = 0; i < length; i++) {
            if (isUpperCase(s.charAt(length - 1 - i))) {
                if (i == 0) {
                    record[i]++;
                } else {
                    record[i] += record[i - 1];
                }
            }

            if (i > 0 && isUpperCase(s.charAt(length - 1 - i), s.charAt(length - i))) {
                if (i == 1) {
                    record[i]++;
                } else {
                    record[i] += record[i - 2];
                }
            }

        }

        return record[length - 1];
    }

    public static void main(String[] args) {
        int i = new L0091DecodeWays().numDecodings("10");
        System.out.println(i);
    }
}
