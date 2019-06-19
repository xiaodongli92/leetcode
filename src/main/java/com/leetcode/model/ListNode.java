package com.leetcode.model;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(String.valueOf(val));
        ListNode temp = next;
        while (temp != null) {
            builder.append(" -> ").append(temp.val);
            temp = temp.next;
        }
        return builder.toString();
    }
}
