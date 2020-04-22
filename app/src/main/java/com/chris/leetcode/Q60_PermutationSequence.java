package com.chris.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q60_PermutationSequence {
    /*
    The set [1,2,3,...,n] contains a total of n! unique permutations.
    By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    Given n and k, return the kth permutation sequence.
    Note:
    Given n will be between 1 and 9 inclusive.
    Given k will be between 1 and n! inclusive.
    Example 1:
    Input: n = 3, k = 3
    Output: "213"

    Example 2:
    Input: n = 4, k = 9
    Output: "2314"
     */
    //筆記
    /*
    以n=4,k=9舉例
    {1,2,3,4}
    step1
        n=4的話代表固定開頭(ex:1)剩下的3個數(2,3,4)總共有3!(6)個排列方法
        所以代表每個數當開頭會有6次
        有此可以知道第K個數的開頭是多少 9/6+1=2 ->s[0] : 2
    step2
        接著我們要找出以2開頭裡面六組的哪一組
        k=9那就是中的 9%3! = 3 : 第三組
        剩下的數字{1,3,4}的重複週期為2!=2次(剩下每個數會出現兩次)
        所以可以知道是第三組是3-> s[1]=3
    step3
        接著23開頭的話就剩下兩組
        9%2!=1->s[2]=1
    step4
        接著231開頭的數字而言, k=9
        9%1!=1
     */
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n + 1];
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //list = {1,2,3,4}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(list.get(index)));
            list.remove(index);
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new Q60_PermutationSequence().getPermutation(4, 9);
    }
}
