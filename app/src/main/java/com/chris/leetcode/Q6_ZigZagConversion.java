package com.chris.leetcode;

public class Q6_ZigZagConversion {
    /*
    INPUT : "PAYPALISHIRING", 3

    OUTPUT: "PAHN APLSIIG YIR"
        3->4
        0p   0a   h   n
        1a 3p l s i i g
        2y   i   r


       4 -> 6
       0 P     0 I    N
       1 A   5 L S  I G
       2 Y  4 A  H R
       3 P       I

       5->8
      0 P          S
      1 A      7 I H
      2 Y   6 L   I   G
      3 P 5 Y     R N
      4 A         I
     */
    public static void main(String[] args) {
        new Q6_ZigZagConversion().convert("AB", 1);
    }

    /*
        逐一拜訪, 不過要注意斜線的部分
        斜線部分需要跟其對應的row一起放入builder內
        斜線部分就是cycler
     */
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1)
            return s;
        StringBuilder str = new StringBuilder();
        int cycler = (numRows * 2 - 2);
        for (int row = 0; row < numRows; row++) {
            for (int i = 0; i < s.length(); i++) {
                int offset = cycler - row;
                if (i % cycler == row || i % cycler == offset) {
                    str.append(s.charAt(i));
                }
            }
        }

        return str.toString();
    }
}
