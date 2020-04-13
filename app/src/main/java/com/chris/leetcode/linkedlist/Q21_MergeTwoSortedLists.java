package com.chris.leetcode.linkedlist;

import com.chris.leetcode.ListNode;

public class Q21_MergeTwoSortedLists {
    /*
      Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
  */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
        new Q21_MergeTwoSortedLists().mergeTwoLists2(l1, l2);
    }

    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
       if (l1!=null) head.next = l1;
       if (l2!=null) head.next = l2;
        return dummy.next;
    }

    /*
    head    0->null
    tail    4
    L1      1->2->4
                  p
    L2      1->3->4
                  p

     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 创建一个头结点，最后还要删除掉
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

               tail = tail.next; // 移动到新的尾结点
        }

        tail.next = (l1 != null ? l1 : l2);

        return dummy.next; // head的下一个节点是第一个数据结点
    }
}
