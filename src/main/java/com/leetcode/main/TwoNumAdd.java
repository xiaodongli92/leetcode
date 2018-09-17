package com.leetcode.main;

import com.leetcode.model.ListNode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoNumAdd {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = new TwoNumAdd().addTwoNumbers(l1, l2);


        while (null != l1) {
            System.out.print(l1.val + " -> ");
            l1 = l1.next;
        }
        System.out.println();
        while (null != l2) {
            System.out.print(l2.val + " -> ");
            l2 = l2.next;
        }
        System.out.println();
        while (null != result) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        ListNode tempResult = result;
        int highValue = (l1.val + l2.val) / 10;
        while (null != l1.next && null != l2.next) {
            l1 = l1.next;
            l2 = l2.next;
            tempResult.next = new ListNode((l1.val + l2.val + highValue) % 10);
            tempResult = tempResult.next;
            highValue = (l1.val + l2.val + highValue) / 10;
        }
        while (null != l1.next) {
            l1 = l1.next;
            tempResult.next = new ListNode((l1.val + highValue) % 10);
            tempResult = tempResult.next;
            highValue = (l1.val + highValue) / 10;
        }
        while (null != l2.next) {
            l2 = l2.next;
            tempResult.next = new ListNode((l2.val + highValue) % 10);
            tempResult = tempResult.next;
            highValue = (l2.val + highValue) / 10;
        }
        if (highValue != 0) {
            tempResult.next = new ListNode(highValue);
        }
        return result;
    }
}
