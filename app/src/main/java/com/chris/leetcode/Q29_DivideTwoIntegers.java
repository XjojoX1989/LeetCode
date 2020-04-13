package com.chris.leetcode;

public class Q29_DivideTwoIntegers {
    /*
    Given two integers dividend and divisor, divide two integers without using multiplication,
    division and mod operator.
    Return the quotient after dividing dividend by divisor.
    The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
    Example 1:
    Input: dividend = 10, divisor = 3
    Output: 3
    Explanation: 10/3 = truncate(3.33333..) = 3.

    Example 2:
    Input: dividend = 7, divisor = -3
    Output: -2
    Explanation: 7/-3 = truncate(-2.33333..) = -2.
     */
    //筆記
    /*
    在不使用乘除餘數的運算方法中找出商
    這一題我們必須運用到java的位元運算符
    a<<1 代表的意思是 a * 2
    a>>1 代表的意思是 a /2
    同時還有另一個數學概念要理解就是
    任意的X皆可以表示為Y*2^a+Y*2^b+Y...+餘數
    所以X/Y的商就是(2^a+2^b+2^...)
     */
    public static void main(String[] args) {
        System.out.println(new Q29_DivideTwoIntegers().divide2(-2147483648, -1));
        System.out.println(new Q29_DivideTwoIntegers().divide2(2147483647, 1));
        System.out.println(new Q29_DivideTwoIntegers().divide2(-5, 2));
    }

    private int divide2(int dividend, int divisor) {
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long ans = 0;
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        while (lDivisor <= lDividend) {
            long temp = lDivisor;
            long mul = 1;
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            lDividend -= temp;
            ans += mul;
        }
        ans *= sign;
        if (ans >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) ans;
    }
}
