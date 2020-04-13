package com.chris.leetcode.linkedlist;

import com.chris.leetcode.ListNode;

public class Q19_RemoveNthNodeFromEndOfList {
    /*
    Given a linked list, remove the n-th node from the end of list and return its head.

    Example:

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
    */

    //筆記
    /*
    創建兩個快慢鏈結
    快鏈結先走n個node(n是題目給定)，才鏈結在開始走
    接著兩個同時走，f的下一個node不為空的時候
    s就會剛好走到題目要求要刪去的那一個節點
    此時如何刪去這個節點呢？
    只要把s.next = s.next.next就略過這個節點了
    因為dummy跟f&s內的節點記憶體位置是一樣的
    所以s略過節點的動作dummy也會跟著略過
    因此dummy.next就是我們的答案了

    dummy  0->1->2->3->4->5
    head      1->2->3->4->5
    slow         s
    fast                  f

     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode b = new Q19_RemoveNthNodeFromEndOfList().removeNthFromEnd2(listNode, 3);
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
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

    private ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow;
        ListNode fast;
        slow = fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
