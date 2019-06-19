package com.leetcode.main;

import com.leetcode.model.ListNode;

/**
 * 合并K个排序链表
 */
public class MergeKList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        System.out.println(l1);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(l2);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        System.out.println(l3);

        ListNode[] lists = {l1, l2, l3};
        System.out.println(mergeKLists(lists));
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode l1 = mergeKLists(lists, start, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, end);
        return merge2Lists(l1, l2);
    }

    private static ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }
        l2.next = merge2Lists(l1, l2.next);
        return l2;
    }
}
