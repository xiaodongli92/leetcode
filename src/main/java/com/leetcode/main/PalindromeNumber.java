package com.leetcode.main;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x !=0)) {
            return false;
        }
        int revert = 0;
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x = x / 10;
        }
        return x == revert || x == revert / 10;
    }
}
