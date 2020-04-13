package com.chris.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q20_ValidParentheses {
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.
    Example 1:

    Input: "()"
    Output: true
    Example 2:

    Input: "()[]{}"
    Output: true

    Example 4:

    Input: "([)]"
    Output: false
     */

    //心得
    /*
    此題要求找到成對的有效括號(){}[]的任意組合
    成對的話我們可以朝著去建立一組 map<'(',')'>這種概念
    把三種括號的map建立起來後
    開始逐一比較
    如果接下來字元是 map 的 key，就把這個字元先存入一個List內
    下一次判斷時如果字元不是map的key，我們就可以用他跟List內的最後一個數據做比對
    為什麼是最後一個？因為括號要連續對應性
    把List內的最後一個數據當作key去取出存在map的值
    看這個值是否跟當前字元一樣，如果一樣的話就代表這是一組有效的括號
    然後把List的最後一筆資料清掉
    最後判別List的size是否為0
    0的話代表給定的字串都是有效括號
     */
    public static void main(String[] args) {
        new Q20_ValidParentheses().isValid2("[([]])");
        new Q20_ValidParentheses().isValid2("([)]");
        new Q20_ValidParentheses().isValid2("(){}[]");
    }

    private boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                list.add(s.charAt(i));
            else {
                if (list.size() == 0) {
                    return false;
                } else {
                    if (s.charAt(i) == map.get(list.get(list.size() - 1)))
                        list.remove(list.size() - 1);
                    else
                        return false;
                }
            }
        }
        return list.size() == 0;
    }

    private boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        } else {
            //先組出一組map
            //  key  : ) ] }
            // value : ( [ {
            Map<Character, Character> parentheseMap = new HashMap<Character, Character>();
            parentheseMap.put(')', '(');
            parentheseMap.put(']', '[');
            parentheseMap.put('}', '{');
            char[] sArr = s.toCharArray();
            List<Character> stackList = new ArrayList<Character>();
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] == '(' || sArr[i] == '[' || sArr[i] == '{') {//如果字串中有我們要的value就塞入list中
                    stackList.add(sArr[i]);
                } else {//沒有的話就代表是key
                    if (stackList.size() == 0) {
                        return false;
                    } else {
                        //找出這組目前的list是否含有這組key對應的value
                        char temp = stackList.get(stackList.size() - 1);//temp就是list內最後一個尚未配對的值
                        if (temp == parentheseMap.get(sArr[i])) {//如果配對成功, 就將這個值刪去代表有對應, 所以list size=0的話就代表都對應了
                            stackList.remove(stackList.size() - 1);
                        } else {
                            return false;
                        }
                    }
                }
            }
            return stackList.size() == 0;
        }
    }
}
