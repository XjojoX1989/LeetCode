package com.chris.leetcode;

public class Q9_PalindromeNumber {
    public static void main(String[] args) {
        new Q9_PalindromeNumber().isPalindrome(0);
        new Q9_PalindromeNumber().isPalindrome(-121);
        new Q9_PalindromeNumber().isPalindrome(123);
        new Q9_PalindromeNumber().isPalindrome(10);
    }

    public boolean isPalindrome(int x) {
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
