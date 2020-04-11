package com.chris.leetcode.string;

public class Q5_LongestPalindrome {
    /*
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
    Example 1:
    Input: "babad"
    Output: "bab"   Note: "aba" is also a valid answer.

    Example 2:
    Input: "cbbd"
    Output: "bb"
     */
    public static void main(String[] args) {
        new Q5_LongestPalindrome().longestPalindrome("babad");
        new Q5_LongestPalindrome().longestPalindrome2("bb");
    }

    public String longestPalindrome2(String s) {
        int length = s.length();
        if (s.length() == 1)
            return s;
        int maxLength = 0;
        String ans = "";
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            maxLength = 1;
            ans = s.substring(i, i + 1);
        }

        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                ans = s.substring(i, i + 2);
            }
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    dp[j][i] = true;
                    if (dp[i + 1][j - 1]) {
                        if ((s.substring(i, j + 1).length() > ans.length())) {
                            ans = s.substring(i, j + 1);
                        }
                    }
                } else {
                    ans = s.substring(i, j);
                }
            }
        }
        return ans;
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
            for (int i = 0, j; (j = i + k - 1) <= length - 1; i++) {// j = i+k-1; j<=length-1
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
