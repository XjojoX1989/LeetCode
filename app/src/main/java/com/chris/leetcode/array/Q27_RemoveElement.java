package com.chris.leetcode.array;

public class Q27_RemoveElement {

    /*
    Given an array nums and a value val,
    remove all instances of that value in-place and return the new length.
    Do not allocate extra space for another array,
    you must do this by modifying the input array in-place with O(1) extra memory.
    The order of elements can be changed. It doesn't matter what you leave beyond the new length.

    Example 1:
    Given nums = [3,2,2,3], val = 3,
    Your function should return length = 2, with the first two elements of nums being 2.
    It doesn't matter what you leave beyond the returned length.

    Example 2:
    Given nums = [0,1,2,2,3,0,4,2], val = 2,
    Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

    Note that the order of those five elements can be arbitrary.

    It doesn't matter what values are set beyond the returned length.
     */
    //筆記
    /*
    重點在於指針移動的方式，到底怎麼樣移動指針
    先創立一個pointer p
    再用一個for回圈分別去比較當前的值是否與 val ㄧ樣
    若一樣->do nothing ,for繼續跑
    若不同->當前for的值給予p指針所在的位置並且p++
    依此類推直到循環結束
     */
    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3};
        int[] b = {0, 1, 2, 2, 3, 0, 4, 2};
        new Q27_RemoveElement().removeElement2(a, 3);
        new Q27_RemoveElement().removeElement2(b, 2);
        new Q27_RemoveElement().removeElement2(b, 2);
    }

    private int removeElement2(int[] nums, int val) {
        int p1 = 0, p2 = 0;
        while (p1 < nums.length) {
            if (nums[p1] != val) {
                nums[p2] = nums[p1];
                p2++;
            }
            p1++;

        }
        return p2;
    }

    private int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }
}
