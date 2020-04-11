package com.chris.leetcode.math;

public class Q12_IntegerToRoman {

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Example 1:                                           Symbol       Value
    Input: 3                                               I             1
    Output: "III"                                          V             5
                                                           X             10
    Example 2:                                             L             50
    Input: 4                                               C             100
    Output: "IV"                                           D             500
                                                           M             1000
    Example 3:
    Input: 9
    Output: "IX"

    Example 4:                                      Example 5:
    Input: 58                                       Input: 1994
    Output: "LVIII"                                 Output: "MCMXCIV"
    Explanation: L = 50, V = 5, III = 3.            Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

     */
    public static void main(String[] args) {
        System.out.println(new Q12_IntegerToRoman().intToRoman2(10));
    }

    /*
    可以用for or while去解
    先建立一個對應的二階陣列羅馬表
    計算的時候從個位數開始找到對應的羅馬文字
    如何去記錄當前的位數？只要建立一個int去記錄即可
    位數的用途是找到目前是第幾階
     */

    String[][] base = new String[][]{
            {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // 个位的表示
            {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, // 十位的表示
            {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // 百倍的表示
            {"M", "MM", "MMM", "", "", "", "", "", ""}}; // 千位的表示

    public String intToRoman2(int num) {
        StringBuilder result = new StringBuilder();
        int digits = 0;
        int temp = 0;
        while (num != 0) {
            temp = num % 10;
            if (temp != 0) {
                result.insert(digits, base[digits][temp-1]);
            }
            digits++;
            num /= 10;
        }
        return result.toString();
    }

    public String intToRoman(int num) {
        String result = "";
        for (int i = 0; num != 0; i++) {
            if (num % 10 != 0) {
                result = base[i][num % 10 - 1] + result;
            }
            num /= 10;
        }
        return result;
    }

}
