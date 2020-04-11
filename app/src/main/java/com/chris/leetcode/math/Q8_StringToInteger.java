package com.chris.leetcode.math;

public class Q8_StringToInteger {
    /*
    Example 1:
    Input: "42"
    Output: 42

    Example 2:
    Input: "   -42"
    Output: -42
    Explanation: The first non-whitespace character is '-', which is the minus sign.
                 Then take as many numerical digits as possible, which gets 42.

    Example 3:
    Input: "4193 with words"
    Output: 4193
    Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

    Example 4:
    Input: "words and 987"
    Output: 0
    Explanation: The first non-whitespace character is 'w', which is not a numerical
                 digit or a +/- sign. Therefore no valid conversion could be performed.

    Example 5:
    Input: "-91283472332"
    Output: -2147483648
    Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
                 Thefore INT_MIN (−2^31) is returned.
     */
    public static void main(String[] args) {
        System.out.println(new Q8_StringToInteger().myAtoi2("   -42"));
        System.out.println(new Q8_StringToInteger().myAtoi2("42"));
        System.out.println(new Q8_StringToInteger().myAtoi2("4193 with words"));
        System.out.println(new Q8_StringToInteger().myAtoi2("words and 987"));
        System.out.println(new Q8_StringToInteger().myAtoi2("-91283472332"));
        System.out.println(new Q8_StringToInteger().myAtoi2("91283472332"));
    }

    private int myAtoi2(String str) {
        if (str.isEmpty())
            return 0;
        int length = str.length();
        int pointer = 0;
        long ans = 0;
        int sign = 1;
        while (pointer < length) {
            if (str.charAt(pointer) == ' ')
                pointer++;
            else if (str.charAt(pointer) == '-' || str.charAt(pointer) == '+') {
                sign = 0;
                pointer++;
            }  else if (str.charAt(pointer) >= '0' && str.charAt(pointer) <= '9') {
                ans = ans * 10 + (str.charAt(pointer) - '0');
                pointer++;
            } else {
                break;
            }
        }
        if (sign == 0) ans *= -1;
        if (ans < Integer.MIN_VALUE)
            ans = Integer.MIN_VALUE;
        if (ans > Integer.MAX_VALUE)
            ans = Integer.MAX_VALUE;
        return (int) ans;
    }

    private int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') {
            ++i;
        }
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }

}
