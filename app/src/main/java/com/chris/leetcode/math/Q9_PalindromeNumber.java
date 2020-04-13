package com.chris.leetcode.math;

public class Q9_PalindromeNumber {
    /*
    是否是回文數字
    把數字每個位數做拆解
    如何取到每個位數？依序把位數％10，餘數就你要的那個數了
     */
    public static void main(String[] args) {
        new Q9_PalindromeNumber().isPalindrome(0);
        new Q9_PalindromeNumber().isPalindrome(-121);
        new Q9_PalindromeNumber().isPalindrome(123);
        new Q9_PalindromeNumber().isPalindrome(10);
    }

    private boolean isPalindrome2(int x) {
        if (x == 0)
            return true;
        if (x < 0 || x % 10 == 0)
            return false;
        int ans = 0;
        while (x > 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans==x;
    }

    private boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0 || x % 10 == 0)
            return false;
        int reverseNum = 0;
        int temp = x;
        while (temp > 0) {
            reverseNum = reverseNum * 10 + temp % 10;
            temp = temp / 10;
        }
        return reverseNum == x;
    }
}
