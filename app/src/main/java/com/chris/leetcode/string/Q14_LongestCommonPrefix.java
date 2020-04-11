package com.chris.leetcode.string;

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
        String[] a = {"flower", "flow", "flight"};
        String[] b = {"dog", "racecar", "car"};
        new Q14_LongestCommonPrefix().longestCommonPrefix3(a);
        new Q14_LongestCommonPrefix().longestCommonPrefix3(b);
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs.length==0)
            return "";
        String first = strs[0];
        int i = first.length();
        for (int j = 1; j < strs.length; j++) {
            while (i >= 0) {
                if (strs[j].indexOf(first)!=0) {
                    first = first.substring(0, i - 1);
                    i--;
                }else
                    break;
            }
        }
        return first;
    }


    /*
    先取出全部陣列的第一個String，先把它當作是prefix
    接著往下做比較，如果不是跟下一個String依樣，就由尾開始刪掉prefix
    一直坐到最後一個String剩下的prefix就是longestCommonPrefix
    這邊學習到 "string".indexOf("string") = 0 :
    就是 自己.indexOf(自己) 會為0 ; 不為自己就是 -1
     */
    public String longestCommonPrefix(String[] strs) {
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

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix2(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix2(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String lcpLeft = longestCommonPrefix2(strs, left, mid);
            String lcpRight = longestCommonPrefix2(strs, mid + 1, right);
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

}
