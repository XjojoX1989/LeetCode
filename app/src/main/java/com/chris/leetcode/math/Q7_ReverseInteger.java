package com.chris.leetcode.math;

public class Q7_ReverseInteger {
    /*
    Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:
    Input: 123
    Output: 321

    Example 2:
    Input: -123
    Output: -321

    Example 3:
    Input: 120
    Output: 21

    Note:
    Assume we are dealing with an environment
    which could only store integers within the
    32-bit signed integer range: [−2^31,  2^31 − 1].
    For the purpose of this problem, assume that your
    function returns 0 when the reversed integer overflows.

     */
    public static void main(String[] args) {
        System.out.println(new Q7_ReverseInteger().reverse2(1534236469));
        System.out.println(new Q7_ReverseInteger().reverse2(-123));
    }
    /*
    筆記
    把數字顛倒其實很簡單,
    只要記得取餘數這個方法就可以了
    對10取取餘數可以拿到當前最後一位的數字
     */
    private int reverse2(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = 0 - x;
        }
        long temp = 0;

        while (x > 0) {
            temp = temp * 10 + x % 10 > Integer.MAX_VALUE ? 0 : temp * 10 + x % 10;
            x /= 10;
        }
        return (int) (isNegative ? 0 - temp : temp);
    }

    private int reverse(int x) {
        long result = 0;
        long temp = x;
        while (temp != 0) {
            result = result * 10 + temp % 10;
            temp = temp / 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }
        return (int) (result);
    }
}
