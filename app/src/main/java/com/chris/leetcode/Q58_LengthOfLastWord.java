package com.chris.leetcode;

public class Q58_LengthOfLastWord {
    /*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
    If the last word does not exist, return 0.
    Note: A word is defined as a maximal substring consisting of non-space characters only.

    Example:
    Input: "Hello World"
    Output: 5
     */

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int pointer = 0;
        int count = 0;
        int max = 0;
        while (pointer < s.length()) {
            if (s.charAt(pointer) != ' ') {
                count++;
                max = count;
            } else {
                count = 0;
            }
            pointer++;
        }
        return max;
    }
}
