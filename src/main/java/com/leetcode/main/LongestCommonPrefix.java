package com.leetcode.main;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = new String[] {"flower","flow","flight"};
        String[] arr2 = new String[] {"dog","racecar","car"};
        String[] arr3 = new String[] {"123", "123", "123"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(arr));
        System.out.println(longestCommonPrefix.longestCommonPrefix(arr2));
        System.out.println(longestCommonPrefix.longestCommonPrefix(arr3));

        System.out.println(longestCommonPrefix.longestCommonPrefix1(arr));
        System.out.println(longestCommonPrefix.longestCommonPrefix1(arr2));
        System.out.println(longestCommonPrefix.longestCommonPrefix1(arr3));
    }

    public String longestCommonPrefix1(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String item : strs) {
            minLength = Math.min(minLength, item.length());
        }
        int start = 1, end = minLength;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isCommonPrefix(strs, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return strs[0].substring(0, (start + end) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String startValue = strs[0].substring(0, length);
        for (int i=1; i<strs.length; i++) {
            if (!strs[i].startsWith(startValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 时间复杂度O(S) S是所有字符串的长度
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i=1; i<strs.length; i++) {
            while (!strs[i].contains(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
