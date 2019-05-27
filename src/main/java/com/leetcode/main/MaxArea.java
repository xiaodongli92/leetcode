package com.leetcode.main;

/**
 * 盛最多水容器
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new MaxArea().maxArea(arr));
    }

    public int maxArea(int[] height) {
        int maxArea = 0,  i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i ++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
