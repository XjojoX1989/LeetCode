package com.chris.leetcode;

public class Q5_LongestPalindrome {
    public static void main(String[] args) {
        new Q5_LongestPalindrome().longestPalindrome("cbacd");
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int maxLength = 0;
        String longest = "";
        int length = s.length();
        boolean[][] table = new boolean[length][length];
        // 单个字符都是回文
        for (int i = 0; i < length; i++) {
            table[i][i] = true;
            longest = s.substring(i, i + 1);
            maxLength = 1;
        }

        // 判断两个字符是否是回文
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                longest = s.substring(i, i + 2);
                maxLength = 2;
            }
        }


        // 求长度大于2的子串是否是回文串
        for (int k = 3; k <= length; k++) {
            for (int i = 0, j; (j = i + k - 1) <= length - 1; i++) {//
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] && maxLength < k) {
                        longest = s.substring(i, j + 1);
                        maxLength = k;
                    }
                } else {
                    table[i][j] = false;
                }
            }
        }

        return longest;


    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
