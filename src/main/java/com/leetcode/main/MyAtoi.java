package com.leetcode.main;

/**
 * 字符串转换整数
 */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("4193 with words"));
        System.out.println(Math.pow(2, 31) == Integer.MAX_VALUE);
        System.out.println(Math.pow(2, -31));
    }

    public int myAtoi(String str) {
        boolean flag = false;
        int i = 0, j;
        for (; i<str.length(); i++) {
            if ('0' <= str.charAt(i) && '9' >= str.charAt(i)) {
                break;
            }
            if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                flag = str.charAt(i) == '-';
                i++;
                break;
            }
            if (str.charAt(i) != ' ') {
                return 0;
            }
        }
        for (j=i; j<str.length(); j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
        }
        String num = str.substring(i, j);
        int result = 0;
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (flag) {
                if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 - cur;
            } else {
                if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                result = result * 10 + cur;
            }
        }
        return result;
    }
}
