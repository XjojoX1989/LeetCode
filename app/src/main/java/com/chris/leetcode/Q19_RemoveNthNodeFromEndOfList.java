package com.chris.leetcode;

import android.util.Log;

import java.util.List;

import static android.content.ContentValues.TAG;

public class Q19_RemoveNthNodeFromEndOfList {
    /*
    Given a linked list, remove the n-th node from the end of list and return its head.

    Example:

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
    */

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode b = new Q19_RemoveNthNodeFromEndOfList().removeNthFromEnd(listNode, 3);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {//找出鏈結的長度
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;//dummy內的鏈結與first內的鏈結共有相同的記憶體位址
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }


}
