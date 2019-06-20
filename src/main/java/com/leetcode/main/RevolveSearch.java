package com.leetcode.main;

/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class RevolveSearch {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 3));
    }

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int revolveIndex = 0;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                revolveIndex = i + 1;
                break;
            }
        }
        if (nums[revolveIndex] == target) {
            return revolveIndex;
        }
        int start, end;
        if (0 == revolveIndex) {
            start = 0;
            end = nums.length-1;
        } else if (nums[0] > target) {
            start = revolveIndex + 1;
            end = nums.length - 1;
        } else {
            start = 0;
            end = revolveIndex - 1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
