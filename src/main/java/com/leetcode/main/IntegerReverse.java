package com.leetcode.main;

public class IntegerReverse {
    public static void main(String[] args) {
        System.out.println(new IntegerReverse().reverse(-123));
    }

    private int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
