package com.chris.leetcode;

public class Q28_ImplementStrStr {
    /*
    Implement C's strstr() or Java's indexOf()
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:
    Input: haystack = "hello", needle = "ll"    Output: 2

    Example 2:
    Input: haystack = "aaaaa", needle = "bba"   Output: -1

    Clarification:
    What should we return when needle is an empty string?
    This is a great question to ask during an interview.
    For the purpose of this problem, we will return 0 when needle is an empty string.
    This is consistent to C's strstr() and Java's indexOf().
     */
    public static void main(String[] args) {
        System.out.println(new Q28_ImplementStrStr().strStr("mississippi", "issipi"));
        System.out.println(new Q28_ImplementStrStr().strStr("helello", "ll"));
        System.out.println(new Q28_ImplementStrStr().strStr("", ""));
    }
    //筆記
    /*
    實作一個java的indextOf()
    其實不難，我們利用for迴圈搭配pointer
    pointer掃過haystack, for迴圈跑needle
    比較當前for跑到的(needle)字元是否跟pointer跑到的(haystack)字元一樣
    如果不一樣pointer++
    如果一樣的話，進一步去比較pointer接下來位置的字元()是否跟整個needle依樣
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        int pointer = 0;
        for (int j = 0; j < needle.length(); j++) {
            while (pointer < haystack.length()) {
                if (needle.charAt(j) != haystack.charAt(pointer))
                    pointer++;
                else {
                    if (pointer + needle.length() <= haystack.length()) {
                        String current = needle.subSequence(0, needle.length()).toString();
                        String target = haystack.subSequence(pointer, pointer + needle.length()).toString();
                        if (current.equals(target)) {
                            return pointer;
                        } else
                            pointer++;
                    } else
                        return -1;
                }
            }
        }
        return -1;
    }
}
