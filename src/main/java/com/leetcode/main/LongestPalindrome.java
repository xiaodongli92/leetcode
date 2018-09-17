package com.leetcode.main;

/**
 * 最长回文子串
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "bb";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome3(s));
    }

    public String longestPalindrome3(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String longestStr = s.substring(0, 1);
        for (int i=0; i<length-1; i++) {
            String temp = extendRange(s, i, i);
            if (temp.length() > longestStr.length()) {
                longestStr = temp;
            }
            temp = extendRange(s, i, i+1);
            if (temp.length() > longestStr.length()) {
                longestStr = temp;
            }
        }
        return longestStr;
    }

    private String extendRange(String s, int start, int end) {
        while (start >=0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                start --;
                end ++;
            } else {
                break;
            }
        }
        return s.substring(start+1, end);
    }

    public String longestPalindrome2(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        int longestLength = 0;
        String longestStr = s.substring(0, 1);
        int[][] matrix = new int[length][length];
        for (int i=0; i<length; i++) {
            matrix[i][i] = 1;
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                matrix[i][i + 1] = 1;
                longestLength = 2;
                longestStr = s.substring(i, i + 2);
            }
        }
        for (int tempLength = 3; tempLength <= length; tempLength++) {
            for (int i = 0; i <= length - tempLength; i++) {
                int j = i + tempLength - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = matrix[i+1][j-1];
                    if (matrix[i][j] == 1 && tempLength > longestLength) {
                        longestLength = tempLength;
                        longestStr = s.substring(i, i + tempLength);
                    }
                }
            }
        }
        return longestStr;
    }

    public String longestPalindrome1(String s) {
        int length = s.length();
        int longestLength = 0;
        String longestStr = "";
        String temp;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                temp = s.substring(i, j);
                if (isPalindrome(temp) && temp.length() > longestLength) {
                    longestLength = temp.length();
                    longestStr = temp;
                }
            }
        }
        return longestStr;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
