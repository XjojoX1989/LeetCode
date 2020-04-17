package com.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q49_GroupAnagrams {
    /*
    Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
     */
    //筆記
    /*
    找到錯位詞, 也就是把相同字元不同的字串放進一組list
    我們必須先區分全部的陣列裡面有幾組要辨識?
    所以其實我們可以把迴圈掃到的字串先改為charArray再去sort這個charArray
    這樣就可以知道是不是同一組
    ex: ate eat tea 其實都是為同一組 'a' 'e' 't'
    如果是同一組的話, 就把他加入hashMap內
    一樣要判斷hashMap有沒有這一組了,
    沒有的話就把
    當前的charArray加入hashMap內(這樣才可以後續比對是否已經有了),map的key就是當前的String(charArray), value就是ans.size)
    當前的字串加入ans內,
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) return ans;
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (map.containsKey(s)) {
                List<String> temp = ans.get(map.get(s));
                temp.add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(s, map.size());
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new Q49_GroupAnagrams().groupAnagrams(a);
    }
}
/*
Output
[["ate","eat","tea"],["bat"],["nat","tan"]]
Expected
[["bat"],["nat","tan"],["ate","eat","tea"]]

Output
[["aet","tea","ate"],["ant","nat"],["abt"]]
Expected
[["bat"],["nat","tan"],["ate","eat","tea"]]
 */