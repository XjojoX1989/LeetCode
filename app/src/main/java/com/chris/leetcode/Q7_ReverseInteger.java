package com.chris.leetcode;

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
        new Q7_ReverseInteger().reverse(1534236469);
        new Q7_ReverseInteger().reverse(-123);
    }

    public int reverse(int x) {
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
