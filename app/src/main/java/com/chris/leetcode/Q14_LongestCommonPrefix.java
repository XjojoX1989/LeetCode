package com.chris.leetcode;

public class Q14_LongestCommonPrefix {
    /*
        Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".

        Example 1:
        Input: ["flower","flow","flight"]
        Output: "fl"

        Example 2:
        Input: ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.
     */
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        new Q14_LongestCommonPrefix().longestCommonPrefix(strings);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String lcpLeft = longestCommonPrefix(strs, left, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, right);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0)
            return "";
        int length = strs.length;
        //先找出第一個字串, 接著逐一比對後面的, 採用減去最後面字元的方式
        String prefix = strs[0];
        for (int i = 0; i < length; i++) {
            while (strs[i].indexOf(i) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.equals(""))
                    return "";
            }
        }
        return prefix;
    }

}
