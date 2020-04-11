package com.chris.leetcode;

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
         */
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        new Q2_AddTwoNumbers().addTwoNumbers(a, b);
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
        if (carry==1)
            cur.next = new ListNode(1);
        return dummy.next;
    }
}
