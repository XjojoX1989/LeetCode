package com.chris.leetcode;

public class Q50_PowXN {
    /*
    Implement pow(x, n), which calculates x raised to the power n (xn).
    Example 1:
    Input: 2.00000, 10
    Output: 1024.00000

    Example 2:
    Input: 2.10000, 3
    Output: 9.26100

   Example 3:
    Input: 2.00000, -2
    Output: 0.25000
    Explanation: 2-2 = 1/22 = 1/4 = 0.25
    Note:
    -100.0 < x < 100.0
    n is a 32-bit signed integer, within the range [−231, 231 − 1]
         */
    private double myPow(double x, int n) {
        if (x == 1) return x;
        boolean isNegative = n < 0;
        long count = Math.abs((long) n);
        double sum = 1;
        while (count > 0) {
            if (count % 2 != 0)
                sum *= x;
            x *= x;
            count /= 2;
        }
        if (isNegative) return 1.0 / sum;
        return sum;
    }

    public double myPow2(double x, int n) {
        if (n > 0)
            return pow(x, n);
        else
            return 1.0 / pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;
        double y = pow(x, n / 2);
        if (n % 2 == 0)
            return y * y;
        else
            return y * y * x;
    }

    public static void main(String[] args) {
        new Q50_PowXN().myPow(2.00000, -2147483648);
    }
}
