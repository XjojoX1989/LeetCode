package com.chris.leetcode;

public class Q24_SwapNodesInPairs {
    /*
    Given a linked list, swap every two adjacent nodes and return its head.
    You may not modify the values in the list's nodes, only nodes itself may be changed.

    Example:
    Given 1->2->3->4, you should return the list as 2->1->4->3.
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        new Q24_SwapNodesInPairs().swapPairs(l1);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0); // 头结点
        dummy.next = head;

        // p指向新的链表的尾结点
        ListNode p = dummy;
        ListNode tmp;

        // 每两个进行操作
        while (p.next != null && p.next.next != null) {
            // 记录下一次要进行处理的位置
            tmp = p.next.next;
            // 下面三句完成两个结点交换
            p.next.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;
            // 指向返回链表的新的尾结点
            p = tmp.next;
        }

        head = dummy.next;
        dummy.next = null;

        return head;
    }
}
