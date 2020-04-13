package com.chris.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class Q22_GenerateParentheses {
    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    For example, given n = 3, a solution set is:
    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]
     */

    //筆記
    /*
    不斷的利用遞迴, 逐一去把左跟右-1
    左減去一的時候, 再進去新的遞迴把左-1當作新的重頭一次遞迴
    結束這一輪後,
    再去右減一的那一個, 進去右-1那一項後再重來一次
    不斷地回直到結束
    終止條件就是減到左或右其中一個為0或左>右
    為什麼要左>右？？
    因為左邊代表的是(
    如果不設定左>右的條件
    則會出現以")"開頭的符號，而這是不符合規則的
    篩選就是左右同為零的時候就可以加入list了
     */
    public static void main(String[] args) {
        new Q22_GenerateParentheses().generateParenthesis2(2);
        new Q22_GenerateParentheses().generateParenthesis2(3);
        new Q22_GenerateParentheses().generateParenthesis(3);
    }

    private List<String> generateParenthesis2(int n) {
        List<String> answer = new ArrayList<>();
        generator2(n, n, "", answer);


        return answer;
    }

    private void generator2(int left, int right, String output, List<String> list) {
        if (left < 0 || right < 0 || left > right)
            return;
        if (left == 0 && right == 0)
            list.add(output);
        generator2(left - 1, right, output + "(", list);
        generator2(left, right - 1, output + ")", list);
    }


    private List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generator(n, n, "", answer);
        return answer;
    }

    private void generator(int left, int right, String output, List<String> answer) {
        if (left < 0 || right < 0 || left > right)
            return;
        if (left == 0 && right == 0) {
            answer.add(output);
        }
        generator(left - 1, right, output + "(", answer);
        generator(left, right - 1, output + ")", answer);

    }
}
