package com.leetcode.main;

import com.leetcode.model.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 26;
        System.out.println(Arrays.toString(twoSum1(nums, target)));

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);
        ListNode result = twoAdd(l1, l2);
        printListNode(result);

        int[] nums1 = new int[] {1};
        int[] nums2 = new int[] {4};
        System.out.println(findMediaSortedArrays(nums1, nums2));

        String s = "12345671238";
        System.out.println(lengthOfLongestSubstring(s));

        String s1 = "acbbbc";
        System.out.println(longestPalindrome1(s1));
        System.out.println(longestPalindrome2(s1));
        System.out.println(longestPalindrome3(s1));
    }

    private static String longestPalindrome3(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        int length = s.length();
        String longestStr = "";
        for (int i=0; i<length-1; i++) {
            String temp = palindromeStr(s, i, i);
            if (temp.length() > longestStr.length()) {
                longestStr = temp;
            }
            temp = palindromeStr(s, i, i+1);
            if (temp.length() > longestStr.length()) {
                longestStr = temp;
            }
        }
        return longestStr;
    }

    private static String palindromeStr(String s, int start, int end) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        }
        return s.substring(start+1, end);
    }

    private static String longestPalindrome2(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        int length = s.length();
        String longestStr = "";
        int[][] arr = new int[length][length];
        for (int i=0; i<length; i++) {
            arr[i][i] = 1;
            if (i < length - 1 && s.charAt(i) == s.charAt(i+1)) {
                arr[i][i+1] = 1;
                longestStr = s.substring(i, i+2);
            }
        }
        for (int tempLength=3; tempLength<=length; tempLength ++) {
            for (int i=0; i<length-tempLength+1; i++) {
                int j=i+tempLength-1;
                if (s.charAt(i) == s.charAt(j)) {
                    arr[i][j] = arr[i+1][j-1];
                    if (arr[i][j] == 1 && tempLength > longestStr.length()) {
                        longestStr = s.substring(i, i+tempLength);
                    }
                }
            }
        }
        return longestStr;
    }

    private static String longestPalindrome1(String s) {
        String longestStr = "";
        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<s.length()+1; j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp) && longestStr.length() < temp.length()) {
                    longestStr = temp;
                }
            }
        }
        return longestStr;
    }

    private static boolean isPalindrome(String s) {
        for (int i=0,j=s.length()-1; i<j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int maxLength = 0;
        int windowSize = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if (map.get(arr[i]) + windowSize < i) {//不在窗口内
                    windowSize ++;
                } else {//在窗口内，表示重复了
                    maxLength = maxLength > windowSize ? maxLength : windowSize;
                    windowSize = i - map.get(arr[i]);
                }
            } else {
                windowSize ++;
            }
            map.put(arr[i], i);
        }
        return maxLength > windowSize ? maxLength : windowSize;
    }

    private static double findMediaSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int lengthAll = nums1.length + nums2.length;
        int idx1 = 0;
        int idx2 = 0;
        int midVal1 = -1;
        int midVal2 = -1;
        while (idx1 + idx2 < lengthAll) {
            if (idx1 < length1) {
                while (idx2 == length2 || nums1[idx1] <= nums2[idx2]) {
                    idx1++;
                    if (idx1 + idx2 == (lengthAll + 1) / 2) {
                        midVal1 = nums1[idx1 - 1];
                    }
                    if (idx1 + idx2 == (lengthAll + 2) / 2) {
                        midVal2 = nums1[idx1 - 1];
                        return (midVal1 + midVal2) * 1.0 / 2;
                    }
                    if (idx1 >= length1) {
                        break;
                    }
                }
            }
            if (idx2 < length2) {
                while (idx1 == length1 || nums2[idx2] <= nums1[idx1]) {
                    idx2++;
                    if (idx1 + idx2 == (lengthAll + 1) / 2) {
                        midVal1 = nums2[idx2 - 1];
                    }
                    if (idx1 + idx2 == (lengthAll + 2) / 2) {
                        midVal2 = nums2[idx2 - 1];
                        return (midVal1 + midVal2) * 1.0 / 2;
                    }
                    if (idx2 >= length2) {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    private static ListNode twoAdd(ListNode l1, ListNode l2) {
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int highVal = (l1.val + l2.val) / 10;
        ListNode temp = result;
        while (null != l1.next && null!= l2.next) {
            l1 = l1.next;
            l2 = l2.next;
            temp.next = new ListNode((l1.val + l2.val + highVal) % 10);
            temp = temp.next;
            highVal = (l1.val + l2.val + highVal) / 10;
        }
        while (null != l1.next) {
            l1 = l1.next;
            temp.next = new ListNode((l1.val + highVal) % 10);
            temp = temp.next;
            highVal = (l1.val + highVal) / 10;
        }
        while (null != l2.next) {
            l2 = l2.next;
            temp.next = new ListNode((l2.val + highVal) % 10);
            temp = temp.next;
            highVal = (l2.val + highVal) / 10;
        }
        if (highVal != 0) {
            temp.next = new ListNode(highVal);
        }
        return result;
    }

    private static void printListNode(ListNode node) {
        System.out.print(node.val);
        while (null != node.next) {
            node = node.next;
            System.out.print(" -> " + node.val);
        }
        System.out.println();
    }

    private static int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        for (int i=0; i<length-1; i++) {
            for (int j=i+1; j<length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


}
