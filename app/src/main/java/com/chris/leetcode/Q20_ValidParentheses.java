package com.chris.leetcode;

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
    public static void main(String[] args) {
        new Q20_ValidParentheses().isValid("(()(");
        new Q20_ValidParentheses().isValid("()[]{}");
    }

    public boolean isValid(String s) {
        if ("".equals(s)) return true;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                list.add(s.charAt(i));
            else {
                if (list.size() == 0) {
                    return false;
                } else {
                    if (map.get(current) == list.get(list.size() - 1))
                        list.remove(list.size() - 1);
                    else
                        return false;
                }
            }
        }
        return list.size() == 0;
    }

    public boolean isValid2(String s) {
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
