package com.chris.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        int ans = new Q3_LengthOfLongestSubstring().bruteForce("abc");
        System.out.println(ans);
        int ans1 = new Q3_LengthOfLongestSubstring().slidingWindow("abcabcbb");
        System.out.println(ans1);
    }
    private int bestSolution(String s){
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

    public int bruteForce(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isAllUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        return ans;
    }

    private boolean isAllUnique(String s, int start, int end) {
        Set<Character> sets = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (sets.contains(s.charAt(i)))
                return false;
            sets.add(s.charAt(i));
        }
        return true;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }
}
