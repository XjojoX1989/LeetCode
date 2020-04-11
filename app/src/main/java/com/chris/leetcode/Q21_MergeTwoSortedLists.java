package com.chris.leetcode;

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
        new Q21_MergeTwoSortedLists().mergeTwoLists(l1, l2);
    }


    /*
    head    0->null
    tail    4
    L1      1->2->4
                  p
    L2      1->3->4
                  p

     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

         //   tail = tail.next; // 移动到新的尾结点
        }

        tail.next = (l1 != null ? l1 : l2);

        return dummy.next; // head的下一个节点是第一个数据结点
    }
}
