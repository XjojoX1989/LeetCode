package com.chris.leetcode.linkedlist;

import com.chris.leetcode.ListNode;

public class Q2_AddTwoNumbers {
    /*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:
    Input: (2 -> 4 -> 3)
         + (5 -> 6 -> 4)
         =  8    0    7

    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.

    筆記：
    ListNode的解題通常我們都會創造一個dummyNode
    並在dummy的最前端任意塞一個數
    接著我們創造一個新的ListNode當作是一個pointer的概念
    讓這個pointer去掃過題目提供的ListNode
    pointer掃的過程中就會一一把我們要的結果一併鍊入dummy內

    本題需要把兩個ListNoed做相加
    有一個要注意的地方就是相加的結果是否 >9 是的話就要進位
    因此需要創立一個int去記錄進位
    最後跑完循環後再根據這個carry是否為1決定是否再進一個位數
         */
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        new Q2_AddTwoNumbers().addTwoNumbers2(a, b);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        int carry = 0;
        ListNode head = dummy;
        while (l1 != null || l2 != null) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum > 9 ? 1 : 0;
            head.next = new ListNode(sum % 10);
            head = head.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry == 1)
            head.next = new ListNode(1);

        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int first = l1 == null ? 0 : l1.val;
            int second = l2 == null ? 0 : l2.val;
            sum = first + second + carry;
            carry = sum > 9 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry == 1)
            cur.next = new ListNode(1);
        return dummy.next;
    }
}
