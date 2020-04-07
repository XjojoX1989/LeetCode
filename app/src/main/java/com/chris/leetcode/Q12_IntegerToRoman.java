package com.chris.leetcode;

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
        new Q12_IntegerToRoman().intToRoman2(1994);
    }

    public String intToRoman2(int num) {
        String[][] base = new String[][]{
                {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // 个位的表示
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, // 十位的表示
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // 百倍的表示
                {"M", "MM", "MMM", "", "", "", "", "", ""}}; // 千位的表示


        String result = "";

        // 每除一次就示处理后一个数位（从小到大）
        // i记录当前处理的是第几个数位
        for (int i = 0; num != 0; i++) {
            // 如果不为0，说明这个数位上有值，要进行相加操作
            if (num % 10 != 0) {
                // 拼接结果
                result = base[i][num % 10 - 1] + result;
                num /= 10;
            }
        }

        return result;
    }

    public String intToRoman(int num) {
        StringBuilder buffer = new StringBuilder();

        numberToRomanChar(buffer, num / 1000, 'M', 'V', '?');
        num = num % 1000;

        numberToRomanChar(buffer, num / 100, 'C', 'D', 'M');
        num = num % 100;

        numberToRomanChar(buffer, num / 10, 'X', 'L', 'C');
        num = num % 10;

        numberToRomanChar(buffer, num, 'I', 'V', 'X');
        return buffer.toString();
    }

    public StringBuilder numberToRomanChar(StringBuilder sb, int x, char n, char h, char b) {
        switch (x) {
            case 9:
                return sb.append(n).append(b);
            case 8:
                return sb.append(h).append(n).append(n).append(n);
            case 7:
                return sb.append(h).append(n).append(n);
            case 6:
                return sb.append(h).append(n);
            case 5:
                return sb.append(h);
            case 4:
                return sb.append(n).append(h);
            case 3:
                return sb.append(n).append(n).append(n);
            case 2:
                return sb.append(n).append(n);
            case 1:
                return sb.append(n);
            default:
                return sb;
        }
    }

}
