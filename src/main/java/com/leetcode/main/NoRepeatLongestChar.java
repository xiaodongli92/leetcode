package com.leetcode.main;

import java.util.*;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 */
public class NoRepeatLongestChar {

    public static void main(String[] args) {
        System.out.println(new NoRepeatLongestChar().lengthOfLongestSubstring("abbade"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int windowSize = 0;
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if(map.get(arr[i]) + windowSize < i){//不在窗口内
                    windowSize++;
                }else{//在窗口内
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
}
