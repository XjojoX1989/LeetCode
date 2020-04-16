package com.chris.leetcode;

public class Q43_MultiplyStrings {
    /*
    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

    Example 1:
    Input: num1 = "2", num2 = "3"
    Output: "6"

    Example 2:
    Input: num1 = "123", num2 = "456"
    Output: "56088"

    Note:
    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
         */
    public static void main(String[] args) {
        new Q43_MultiplyStrings().multiply("2", "1");
    }
    //筆記
    /**
    將數字的字串相乘再以字串輸出
    這題用到位數的概念
    我們先把把兩個數字相乘後的位數用陣列保存
    例如:2位數*3位數最多就是5位數(2+3)
    接著我們把每個位數相乘的結果存進他們對應的位數裡面
    例如: 23*14 先算個位數 3*4 = 12 我們就要把12存進陣列內
    那他們是存進哪裡呢?
    3在原本的數裡面他的index=1 ,
    4在原本的數裡面他的index=1
    所以 12中的2 -> 1+1+1 = 3 (i+j+1)
        12中的1 -> 1+1 = 2  (i+J)
                  2 3
                x 1 4
                -------
                  1 2
                0 8
                0 3
              0 2
            --------------
     sum      0 3 2 2
    indices    0 1 2 3

     */
    private String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "0";
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = product + digits[p2];
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int digit:digits){
            if (!(digit==0 && sb.length()==0))
                sb.append(digit);
        }
        return sb.toString();
    }
}
