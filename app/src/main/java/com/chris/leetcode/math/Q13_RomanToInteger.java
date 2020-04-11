package com.chris.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class Q13_RomanToInteger {
    public static void main(String[] args) {
        new Q13_RomanToInteger().romanToInt("XCIX");//99
        new Q13_RomanToInteger().romanToInt("MCDLXXVI");//1476
        new Q13_RomanToInteger().romanToInt("MCMXCIV");//1944
    }

    /*
    M    C    M   X   C   I  V
   1000 100 1000 10  100  1  5
    5-1+100-10+1000-100+1000=


     Example 1:                                           Symbol       Value
    Input: 3                                               I             1
    Output: "III"                                          V             5
                                                           X             10
    Example 2:                                             L             50
    Input: 4                                               C             100
    Output: "IV"                                           D             500
                                                           M             1000
        M     C   D   L   X   X   V   I
        1000 100 500 50  10  10  5   1
        1000+400+70+6

     將羅馬數字改為整數，這題是整數改為羅馬計數的相反題
     我們可以由左至右一個一個判斷
     若當前的羅馬文字代表的數比前一個還要 大 or 相等 : 則加，
     反若當前的羅馬文字代表的數比前一個要 小         : 則減
     */

    public int romanToInt2(String s) {
        int result = 0;
        int prev = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            switch (s.charAt(i)) {
                case 'I': // 1
                    if (1 < prev) result -= 1;
                    else result += 1;
                    prev = 1;
                    break;
                case 'V': // 5
                    if (5 < prev) result -= 5;
                    else result += 5;
                    prev = 5;
                    break;
                case 'X': // 10
                    if (10 < prev) result -= 10;
                    else result += 10;
                    prev = 10;
                    break;
                case 'L': // 50
                    if (50 < prev) result -= 50;
                    else result += 50;
                    prev = 50;
                    break;
                case 'C': // 100
                    if (100 < prev) result -= 100;
                    else result += 100;
                    prev = 100;
                    break;
                case 'D': // 500
                    if (500 < prev) result -= 500;
                    else result += 500;
                    prev = 500;
                    break;
                case 'M': // 1000
                    result += 1000;
                    prev = 1000;
                    break;
            }
        }
        return result;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int answer = 0;
        int previous = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            int currentValue = map.get(s.charAt(i));
            if (currentValue >= previous)
                answer += currentValue;
            else
                answer -= currentValue;

            previous = currentValue;
        }
        return answer;

    }
}
