package com.chris.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3_LengthOfLongestSubstring {
    /*
    Given a string, find the length of the longest substring without repeating characters.

    Example 1:
    Input: "abcabcbb"
    Output: 3     Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: "bbbbb"
    Output: 1    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: "pwwkew"
    Output: 3    Explanation: The answer is "wke", with the length of 3.
    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public static void main(String[] args) {
        int ans = new Q3_LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
        int ans1 = new Q3_LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb");
        System.out.println(ans1);
    }

    private int bestSolution(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    private int slidingWindow(String s) {
        int length = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < length && j < length) {//分別從i,j=0開始
            if (!set.contains(s.charAt(j))) {//如果Set中不包含字串裡的字
                set.add(s.charAt(j));//將字加入Set中
                ans = Math.max(ans, j - i + 1);//j-i=目前拜訪過的字(可是少1, 因為是從0開始所以要+1)
                j++;//拜訪下一個字
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return ans;
    }

    /*  0   1   2   3   4   5
        p   w   w   k   e   w
                    i
            j
     set{w,k}
     1,2
     筆記：
     我們使用兩個指標去分別掃過這個字串
     指標一若移動：還在掃當前這一輪
     指標二若移動：進入新的一輪
     然後創建一個Set去存掃過的字元
     若掃過的字元"不在"Set內的話，我們就將此字元加入Set內，並將第一個指標移動一位
     這一次的循環掃過多少個字元 : (i-j+1)
     創建一個int ans = 之前的循環掃過最多的字元
     若掃過的字元"在"Set內的話，我們就將此字元移除，
     並將第二個指標移動一位(代表新一次的循環了）
     */
    private int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int ans = 0, i = 0, j = 0;
        int theCharsThatHadMoved = 0;
        Set<Character> sets = new HashSet<>();
        while (i < length && j < length) {
            theCharsThatHadMoved = i - j + 1;
            if (!sets.contains(s.charAt(i))) {
                sets.add(s.charAt(i));
                ans = Math.max(ans, theCharsThatHadMoved);
                i++;
            } else {
                sets.remove(s.charAt(j));
                j++;
            }
        }
        return ans;
    }
}
